package com.customerCRUD.model.dao;
import java.util.*;

import com.customerCRUD.model.service.CustomerService;
import com.customerCRUD.model.service.CustomerServiceImpl;
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		CustomerService dao=new CustomerServiceImpl();
		
		Date date1 = new Date("20110909");
		dao.addCustomer(new Customer("Rajeev", "Delhi", 1234567890, date1));
		dao.addCustomer(new Customer("Ekta","Ghaziabad",687653211, new Date("20100101")));
		
		Customer customer1 = dao.getCustomerById(1);
		System.out.println(customer1);

		List<Customer> customers=dao.getAllCustomers();
		customers.forEach(c-> System.out.println(c));
		
	}
}
