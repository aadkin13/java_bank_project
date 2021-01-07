package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.app.dao.EmployeeCrudDAO;
import com.app.dao.UserCrudDAO;
import com.app.dao.impl.EmployeeCrudDAOImpl;
import com.app.dao.impl.UserCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Users;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		UserCrudDAO userDao = new UserCrudDAOImpl();
		EmployeeCrudDAO emplDao = new EmployeeCrudDAOImpl();
		UserCrudDAO dao = new UserCrudDAOImpl();
		Scanner input = new Scanner(System.in);
		
		//Users user = new Users("aja", "demo", "9196657234", "aj@demo.com");
		
		String username, password, phoneNumber, email;
		
		log.info("Enter username: ");
		username = input.next();
		log.info("Enter password: ");
		password = input.next();
		log.info("Enter phone number: ");
		phoneNumber = input.next();
		log.info("Enter email: ");
		email = input.next();
		
		Users user = new Users(username, password, phoneNumber, email);

		
		try {
			if(dao.createUser(user) != 0) {
				log.trace("User Created!");
			}
			log.trace(dao.getUserByUsername("aja"));
			for(Users x : dao.getAllUsers()) {
				log.trace(x);
			}
			
			dao.deleteUser("aja");
			
		}catch(BusinessException e) {
			log.trace(e.getMessage());
			//System.out.println(e.getMessage());
		}
		
	}

}
