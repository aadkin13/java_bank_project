package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.SQLException;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.dao.EmployeeCrudDAO;
import com.app.dao.dbutil.PostgresqlConnection;

public class EmployeeCrudDAOImpl implements EmployeeCrudDAO{
	Random rand = new Random();

	@Override
	public int createEmpl(Employee empl) throws BusinessException {
		int c;
		int userId = rand.nextInt() & Integer.MAX_VALUE;
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "insert into bank_db.bank.bank_employee(employee_id, employee_username, employee_password, employee_email, employee_phone_number) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, empl.getEmplUsername());
			preparedStatement.setString(3, empl.getPassword());
			preparedStatement.setString(4, empl.getEmail());
			preparedStatement.setString(5, empl.getPhoneNumber());
			
			c = preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		return c;
	}

	@Override
	public void deleteEmpl(String empl_username) {
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "delete from bank_db.bank.bank_employee where employee_username = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, empl_username);
			preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Employee getEmployeeByEmplUsername(String emplUsername) throws BusinessException {
		Employee empl = null;
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "select * from bank_db.bank.bank_employee where employee_username = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, emplUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				empl = new Employee();
				empl.setEmplUsername(emplUsername);
				empl.setPassword(resultSet.getString("employee_password"));
				empl.setEmail(resultSet.getString("employee_email"));
				empl.setEmplPhoneNumber(resultSet.getString("employee_phone_number"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		return empl;
	}

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> emplList = new ArrayList<>();
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "select * from bank_db.bank.bank_employee";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee empl = new Employee();
				empl.setEmplUsername(resultSet.getString("employee_username"));
				empl.setPassword(resultSet.getString("employee_password"));
				empl.setEmail(resultSet.getString("employee_email"));
				empl.setEmplPhoneNumber(resultSet.getString("employee_phone_number"));
				emplList.add(empl);
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		return emplList;
	}

}
