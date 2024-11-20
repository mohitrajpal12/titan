package com.mr.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


//import antlr.collections.List;
@Entity
@Table(name ="Dept")
public class Department {
	@Id
	private int deptNo;
	@Column(name ="dname",length =15)
	private String deptName;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> emps;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Department(int deptNo, String deptName) {
		
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	
	public Department() {
		
	}

	public Department(int deptNo, String deptName, List<Employee> emps) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.emps = emps;
	}
	
	
	
}
