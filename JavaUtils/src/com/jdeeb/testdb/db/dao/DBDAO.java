package com.jdeeb.testdb.db.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jdeeb.testdb.db.entities.IEntity;
/**
 * 
 * @author JDeeb
 *
 */
public class DBDAO<T extends IEntity> {
	
	private EntityManager em;
	
	public DBDAO(EntityManager em){
		this.em = em;
	}
	
	public void save(T t){
		em.getTransaction().begin();
		if(!em.contains(t))
			em.persist(t);
		else
			em.merge(t);
		em.getTransaction().commit();
	}
	public void update(){
		
	}
	public void delete(){
		
	}
	
	public List<T> getAll(Class<T> t,String namedQuery){
		List<T> results = (List<T>) em.createNamedQuery(namedQuery,t).getResultList();
		return results;
	}
	
	public T getById(Class<T> t, int id){
		return (T) em.find(t, id);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getByNamedQuery(Class<T> t, String namedQuery, Map<String, Object> paremeters){
		if(namedQuery != null && !namedQuery.isEmpty()){
			Query query = null;
			if( t != null)
				query = em.createNamedQuery(namedQuery, t);
			else
				query = em.createNamedQuery(namedQuery);
			
			if(paremeters != null)
				for (Map.Entry<String, Object> entry : paremeters.entrySet())
					query.setParameter(entry.getKey(), entry.getValue());
			
			System.out.println("Query: " + query.toString());
			List<T> results = query.getResultList();
			return results;
		}else{
			return null;
		}
	}
}
