package com.mr.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mr.dao.CustomerDao;
import com.mr.entity.Customer;

public class TestCustomerDao {
		
	private static CustomerDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer(121,"Mohit","kamptee");
		dao.save(c);
	}
	
	@Test
	public void testFind() {
		Customer c = dao.find(121);
		assertNotNull(c);
		System.out.println(c);
	}
	
	@Test
	public void remove() {
		
		assertTrue(dao.remove(121));
	}
}
