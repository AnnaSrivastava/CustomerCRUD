package com.customerCRUD.model.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customerCRUD.model.dao.factories.JDBCConnectionFactory;
import com.customerCRUD.model.exceptions.CustomerNotFoundException;
import com.customerCRUD.model.exceptions.DataAccessException;

public class CustomerDaoImpl implements CustomerDao{

	private Connection connection;
	
	public CustomerDaoImpl() {
		connection=JDBCConnectionFactory.getConnection();
	}
	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		Customer tempCustomer;
		try {
			String all_customers_query = "select * from customers";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(all_customers_query);
			while (rs.next()) {
				tempCustomer = new Customer(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("address"),
						rs.getInt("phoneNo"), 
						rs.getDate("dob"));

				customers.add(tempCustomer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());
		}
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		try {
			String add_book_query=
			"insert into customers(id, name, address, phoneNo, dob) values(?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(add_book_query, 
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, customer.getId());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setInt(4, customer.getPhoneNo());
			pstmt.setDate(5, new Date(customer.getDob().getTime()));
			
			int noOfRowsEffected=pstmt.executeUpdate();
			
			if(noOfRowsEffected>0) {
				ResultSet rs=pstmt.getGeneratedKeys();
				rs.next();
				customer.setId(rs.getInt(1));
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());
		}
		
		return customer;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer=null;
		try {
			String get_customer_by_id="select * from customers where id=?";
			PreparedStatement pstmt= connection.prepareStatement(get_customer_by_id);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				customer=new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getInt("phoneNo"), rs.getDate("dob"));
			}else {
				throw new CustomerNotFoundException("book with id "+ id +" is not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return customer;
	}

	


}
