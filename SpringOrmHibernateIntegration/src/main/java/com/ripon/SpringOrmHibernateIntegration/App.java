package com.ripon.SpringOrmHibernateIntegration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ripon.entities.Customer;
import com.ripon.doa.*;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		
		/*  Inserting records
		Customer c = new Customer();
		c.setCustomerId(468);
		c.setCustomerName("naresh");
		System.out.println(customerDao.insertCustomer(c));
		*/
		
		//System.out.println(customerDao.update(c));
		
		//Customer c1 = customerDao.getCustomer(12);
		
		System.out.println(customerDao.delete(468));
		 

	}

}