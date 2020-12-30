package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Users;

public interface UserCrudDAO {
	public int createUser(Users user) throws BusinessException;
	public void deleteUser(String username) ;
	public Users getUserByUsername(String username) throws BusinessException;
	public List<Users> getAllUsers() throws BusinessException;
}
