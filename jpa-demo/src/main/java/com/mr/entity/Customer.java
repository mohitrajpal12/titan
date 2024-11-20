package com.mr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @entity is to tell the computer that this class is connected to a table
// @Table(name =" ") -> to give table name
// @Id -> we write above that property to which we have to make primary key
//@column(name="cust_id") -> to give column name
// @Column(name = "Cname",length =20) to give column name and lenght
//@Column(length = 15 , nullable = false) to give column name and length
// in above we have not mentioned name of column so it will take the variable name as column name





@Entity
@Table(name = "cust")
public class Customer {
	@Id
	@Column(name = "cust_id")
	private int custId;
	@Column(name = "Cname",length =20)
	private String custName;
	@Column(length = 15 , nullable = false)
	private String city;
	
	
	// below lines of code are for input and output of attributes
	
	public Customer(int custId, String custName, String city) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.city = city;
	}

	public Customer() {
		
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
