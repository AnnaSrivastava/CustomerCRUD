package com.customerCRUD.model.dao;

import java.util.Date;

public class Customer {
	private int id;
	private String name;
	private String address;
	private int phoneNo;
	private Date dob;
	public Customer() {	}
	public Customer(String name, String address, int phoneNo, Date dob) {
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.dob = dob;
	}
	public Customer(int id, String name, String address, int phoneNo, Date dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
