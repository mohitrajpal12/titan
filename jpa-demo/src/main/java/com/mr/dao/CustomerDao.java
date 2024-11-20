package com.mr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mr.entity.Customer;
//import com.mysql.cj.Query;

public class CustomerDao {
	
	// functionalities save ,find list of customer , remove cust
	
	private EntityManager getManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("first-jpa");
		return factory.createEntityManager();
	}
	
	public void save(Customer c) {
		EntityManager mgr  = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(c);  // c -> txn
		txn.commit();
		
		mgr.close();
	}
	
	public Customer find(int id) {
		EntityManager mgr = getManager();
		
		Customer c =mgr.find(Customer.class, id);
		return c;
	}
	
	public List<Customer> list(){
		EntityManager mgr = getManager();
		Query query = mgr.createQuery("FROM Customer");
		return query.getResultList();	
	}
	
	public boolean remove(int id) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Customer c = mgr.find(Customer.class, id);
		mgr.remove(c);
		txn.commit();
		mgr.close();
		return true;
	}
	
}
