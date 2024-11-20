package com.mr.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mr.entity.Customer;
import com.mr.entity.Department;
import com.mr.entity.Employee;

public class EmpDeptDao {
   
	private EntityManager getManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("first-jpa");
		return factory.createEntityManager();
	}
	
	public void saveEmp(Employee emp , int deptNo) {
		EntityManager mgr  = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Department dept = mgr.find(Department.class,deptNo);
		emp.setDept(dept);
		mgr.persist(emp);
		txn.commit();
		mgr.close();
	}
	
	public void saveDept(Department dept) {
		EntityManager mgr  = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		mgr.persist(dept);
		txn.commit();
		mgr.close();
	}

	
	public Employee getEmp(int empNo) {
		EntityManager mgr = getManager();
		return mgr.find(Employee.class, empNo);
	}
		
	public List<Customer> getAllEmp()
	{
		EntityManager mgr = getManager();
		Query query = mgr.createQuery("FROM Employee");
		return query.getResultList();	
	}
	
	public boolean removeEmployee(int id) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Employee e = mgr.find(Employee.class, id);
		mgr.remove(e);
		txn.commit();
		mgr.close();
		return true;
	}
	
	
	public Department getDept(int depNo) {
		EntityManager mgr = getManager();
		return mgr.find(Department.class, depNo);
	}
	
	
	
	
	public List<Department> getAllDept()
	{
		EntityManager mgr = getManager();
		Query query = mgr.createQuery("FROM Department");
		return query.getResultList();	
	}
	
	public boolean deleteDepartment(int id) {
		EntityManager mgr = getManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Department dept = mgr.find(Department.class, id);
		mgr.remove(dept);
		txn.commit();
		mgr.close();
		return true;
	}
	
	
}
