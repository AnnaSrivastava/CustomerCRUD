package com.customerCRUD.model.service;

import java.util.List;

import com.customerCRUD.model.dao.Customer;
import com.customerCRUD.model.dao.CustomerDao;
import com.customerCRUD.model.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		customerDao=new CustomerDaoImpl();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}


}

