package com.ripon.hibe.Dao;

import java.util.List;

import com.ripon.hibe.bean.Customer;

public interface CustomerDao {

	public void createRecord(Customer customer);
	
	public void updateRecord(Customer custome);
	
	public void deleteRecord(Integer customerId);
	
	public List<Customer> getAllCustomers();
	
	public List<Customer> getAllCustomersHql();
}
