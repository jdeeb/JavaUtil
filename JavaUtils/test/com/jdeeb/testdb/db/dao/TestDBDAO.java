package com.jdeeb.testdb.db.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

import com.jdeeb.testdb.db.entities.User;
import com.jdeeb.testdb.db.utils.DBConnectionManager;
import java.util.logging.*;

public class TestDBDAO {
	private final static Logger logger = Logger.getLogger(TestDBDAO.class.getName());
	
	@Test
	public void testDBDAO() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		logger.entering(getClass().getName(), "testGetAll");
		DBConnectionManager conn = new DBConnectionManager();
		
		DBDAO<User> dao = new DBDAO<User>(conn.getEntityManager());
		List<User> users = dao.getByNamedQuery(User.class, "User.findAll",null);
		for(User user: users){
			System.out.println("Email: " + user.getEmail());
			System.out.println("UserName: " + user.getUsername());
			System.out.println("Password: " + user.getPassword());
		}
		System.out.println(users.size());
		logger.exiting(getClass().getName(), "testGetAll");
		assertTrue(users.size() > 0);
	}
	/*
	@Test
	public void testGetById() {
		DBConnectionManager conn = new DBConnectionManager();
		
		DBDAO<User> dao = new DBDAO<User>(conn.getEntityManager());
		User user = dao.getById(User.class, 1);
		System.out.println("UserName: " + user.getUsername());
		assertTrue(user.getUsername() != null);
	}*/

	@Test
	public void testLogin() {
		DBConnectionManager conn = new DBConnectionManager();
		
		DBDAO<User> dao = new DBDAO<User>(conn.getEntityManager());
		HashMap<String, Object> paremeters = new HashMap<String, Object>();
		paremeters.put("userName", "ahmed");
		paremeters.put("password", "123");
		List<User> users = dao.getByNamedQuery(User.class, "User.login",paremeters);
		for(User user: users){
			System.out.println("Email: " + user.getEmail());
			System.out.println("UserName: " + user.getUsername());
			System.out.println("Password: " + user.getPassword());
		}
		assertTrue(users.size() > 0);
	}
}
