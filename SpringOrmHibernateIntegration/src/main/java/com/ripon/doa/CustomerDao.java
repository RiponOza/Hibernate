package com.ripon.doa;

import com.ripon.entities.Customer;

public interface CustomerDao {
	
	public String insertCustomer(Customer customer);
	
	public String update(Customer customer);
	
	public String delete(int customerId);
	
	public Customer getCustomer(int customerId);

}