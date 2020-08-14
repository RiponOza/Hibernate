package com.ripon.SpringOrmHibernateIntegration;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ripon.entities.Customer;
import com.ripon.config.SpringConfig;
import com.ripon.doa.*;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		//ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		
		/*  Inserting records
		Customer c = new Customer();
		c.setCustomerId(468);
		c.setCustomerName("naresh");
		System.out.println(customerDao.insertCustomer(c));
		*/
		
		//System.out.println(customerDao.update(c));
		
		//Customer c1 = customerDao.getCustomer(12);
		
		//System.out.println(customerDao.delete(2005));
		 
		List<Customer> customers = customerDao.getAllCustomer();
		
		for(Customer customer : customers) {
			System.out.println("Id = " + customer.getCustomerId());
			System.out.println("Name" + customer.getCustomerName());
			System.out.println("========================================");
		}
		
		
		
	}

}