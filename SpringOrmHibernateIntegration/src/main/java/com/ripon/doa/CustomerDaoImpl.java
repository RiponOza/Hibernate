package com.ripon.doa;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ripon.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public String insertCustomer(Customer customer) {
		String message ="";
		try {
			hibernateTemplate.save(customer);
			message = "Insert Succcess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message ="Insert Failure";
		}
		return message;
	}
	
	@Transactional
	public String update(Customer customer) {
		String message ="";
		try {
			hibernateTemplate.update(customer);
			message = "Update Succcess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message ="Update Failure";
		}
		return message;
	}

	@Transactional
	public String delete(int customerId) {
		String message ="";
		Customer customer = getCustomer(customerId);
		if(customer != null) {
			try {
				hibernateTemplate.delete(customer);
				message = "Deletion Succcess";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message ="Deletion Failure";
			}
		} else {
			message = "Customer with this Id is not available...";
		}
		return message;
	}

	
	public Customer getCustomer(int customerId) {
		Customer customer = null;
		try {
			customer = (Customer)hibernateTemplate.get(Customer.class, customerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		return customer;
	}
}