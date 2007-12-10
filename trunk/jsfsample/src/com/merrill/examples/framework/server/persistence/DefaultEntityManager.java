package com.merrill.examples.framework.server.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DefaultEntityManager implements EntityManager {

	@PersistenceContext
	private EntityManager entityManager;

	public DefaultEntityManager() {
	//	this.entityManager = new EntityManagerProvider().getEntityManager();
	}

	public void clear() {
		entityManager.clear();
	}

	public void close() {
		entityManager.close();
	}

	public boolean contains(Object arg0) {
		return entityManager.contains(arg0);
	}

	public Query createNamedQuery(String arg0) {
		return entityManager.createNamedQuery(arg0);
	}

	public Query createNativeQuery(String arg0, Class arg1) {
		return entityManager.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0, String arg1) {
		return entityManager.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0) {
		return entityManager.createNativeQuery(arg0);
	}

	public Query createQuery(String arg0) {
		return entityManager.createQuery(arg0);
	}

	public <T> T find(Class<T> arg0, Object arg1) {
		return entityManager.find(arg0, arg1);
	}

	public void flush() {
		entityManager.flush();
	}

	public Object getDelegate() {
		return entityManager.getDelegate();
	}

	public FlushModeType getFlushMode() {
		return entityManager.getFlushMode();
	}

	public <T> T getReference(Class<T> arg0, Object arg1) {
		return entityManager.getReference(arg0, arg1);
	}

	public EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}

	public boolean isOpen() {
		return entityManager.isOpen();
	}

	public void joinTransaction() {
		entityManager.joinTransaction();
	}

	public void lock(Object arg0, LockModeType arg1) {
		entityManager.lock(arg0, arg1);
	}

	public <T> T merge(T arg0) {
		return entityManager.merge(arg0);
	}

	public void persist(Object arg0) {
		entityManager.persist(arg0);
	}

	public void refresh(Object arg0) {
		entityManager.refresh(arg0);
	}

	public void remove(Object arg0) {
		entityManager.remove(arg0);
	}

	public void setFlushMode(FlushModeType arg0) {
		entityManager.setFlushMode(arg0);
	}
	
	

}
