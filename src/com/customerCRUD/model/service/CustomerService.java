package com.customerCRUD.model.service;

import java.util.List;

import com.customerCRUD.model.dao.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer getCustomerById(int id);
	
}
