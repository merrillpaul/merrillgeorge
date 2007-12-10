package com.merrill.examples.framework.server.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerProvider {
	
	private static EntityManagerFactory factory;
	
	public EntityManager getEntityManager(){
		if(factory ==null){
			factory = Persistence.createEntityManagerFactory("default");
		}
		
		return factory.createEntityManager();
	}

}
