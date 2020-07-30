package com.ripon.hibe.Dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.sql.*;

import com.ripon.hibe.bean.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Session session = HibernateUtil.getSessionObject();	//session object
	
	public void createRecord(Customer customer) {
		session.save(customer);
		session.beginTransaction().commit();
        System.out.println("Successfully Inserted....");
	}

	public void updateRecord(Customer customer) {
		if(session.get(Customer.class, customer.getCustomerId())!=null) {
			session.saveOrUpdate(customer);
		}
		
	}

	public void deleteRecord(Integer customerId) {
		Customer customer =(Customer) session.get(Customer.class, customerId);
		if(customer!=null) {
			session.delete(customer);
			session.beginTransaction().commit();
			System.out.println("Successfully deleted....");
		}
		else {
			System.out.println("Record not found...");
		}
		
	}

	public List<Customer> getAllCustomers() {
		return session.createNativeQuery("select * from customers").list();
	}

	public List<Customer> getAllCustomersHql() {
		return session.createQuery("select c from Customer c").list();
	}
	
	

}
