package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeCrudDAO {
	public int createEmpl(Employee empl) throws BusinessException;
	public void deleteEmpl(String empl_username);
	public Employee getEmployeeByEmplUsername(String emplUsername) throws BusinessException;
	public List<Employee> getAllEmployees() throws BusinessException;
}
 