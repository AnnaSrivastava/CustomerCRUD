package com.customerCRUD.model.dao;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer book);
	public Customer getCustomerById(int id);

}