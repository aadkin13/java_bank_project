package com.app.main;

import com.app.dao.UserCrudDAO;
import com.app.dao.impl.UserCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Users;

public class Main {
	
	public static void main(String[] args) {
		UserCrudDAO dao = new UserCrudDAOImpl();
		
		Users user = new Users("aja", "demo", "9196657234", "aj@demo.com");
		
		try {
			if(dao.createUser(user) != 0) {
				System.out.println("User Created!");
			}
			System.out.println(dao.getUserByUsername("aja"));
			for(Users x : dao.getAllUsers()) {
				System.out.println(x);
			}
			dao.deleteUser("aja");
			
		}catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
