package com.jdeeb.testdb.db.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionManager {
	private static final String PERSISTENCE_UNIT_NAME = "com.jdeeb.TestDB";
    private static EntityManagerFactory factory;
    private EntityManager em;
    
	public EntityManager getEntityManager() {
		if(em == null){
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			if(factory != null){
				em = factory.createEntityManager();	
				//System.out.println(em.isOpen());
			}else{
				System.out.println("Failed to create FacrotyManager.");
			}
		}
		return em;
	}
	public void releaseConnection(){
		if(em != null && em.isOpen()) em.close();
	}
	public void commit(){
		
	}
	public void rollback(){
		
	}
}
