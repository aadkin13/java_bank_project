package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.app.dao.UserCrudDAO;
import com.app.dao.dbutil.PostgresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Users;

public class UserCrudDAOImpl implements UserCrudDAO{
	Random rand = new Random();
	
	@Override
	public int createUser(Users user) throws BusinessException {
		int c;
		int userId = rand.nextInt() & Integer.MAX_VALUE;
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "insert into bank_db.bank.bank_users(user_id, username, password, phone_number, email) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getPhoneNumber());
			preparedStatement.setString(5,user.getEmail());
			
			c = preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		
		return c;
	}

	@Override
	public void deleteUser(String username) {
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "delete from bank_db.bank.bank_users where username = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,username);
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public Users getUserByUsername(String username) throws BusinessException {
		Users user = null;
		try (Connection conn = PostgresqlConnection.getConnection()){
			String sql = "select * from bank_db.bank.bank_users where username = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new Users();
				user.setUserId(resultSet.getInt("user_id"));
				user.setUsername(username);
				user.setPassword(resultSet.getString("password"));
				user.setUserPhoneNumber(resultSet.getString("phone_number"));
				user.setEmail(resultSet.getString("email"));
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		return user;
	}

	@Override
	public List<Users> getAllUsers() throws BusinessException {
		List<Users> userList = new ArrayList<>();
		try(Connection conn = PostgresqlConnection.getConnection()){
			String sql = "select * from bank_db.bank.bank_users;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Users user = new Users();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setUserPhoneNumber(resultSet.getString("phone_number"));
				user.setEmail(resultSet.getString("email"));
				userList.add(user);
			}
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Error");
		}
		return userList;
	}
	
	

}
