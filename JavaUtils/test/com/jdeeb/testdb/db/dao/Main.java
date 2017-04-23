package com.jdeeb.testdb.db.dao;

import java.util.List;
import java.util.logging.Logger;

import com.jdeeb.testdb.db.entities.User;
import com.jdeeb.testdb.db.utils.DBConnectionManager;

public class Main {
	private final static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args){
		logger.entering("Main", "testGetAll");
		DBConnectionManager conn = new DBConnectionManager();
		
		DBDAO<User> dao = new DBDAO<User>(conn.getEntityManager());
		List<User> users = dao.getByNamedQuery(User.class, "User.findAll",null);
		for(User user: users){
			System.out.println("Email: " + user.getEmail());
			System.out.println("UserName: " + user.getUsername());
			System.out.println("Password: " + user.getPassword());
		}
		System.out.println(users.size());
		logger.exiting("Main", "testGetAll");
	}
}
