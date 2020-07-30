package com.ripon.hibe.HibernateApp;

import java.util.List;

import com.ripon.hibe.Dao.CustomerDao;
import com.ripon.hibe.Dao.CustomerDaoImpl;
import com.ripon.hibe.bean.Customer;

public class App 
{
    public static void main( String[] args )
    {
        CustomerDao cdao = new CustomerDaoImpl();
        
        
//        Customer customer = new Customer();
//        customer.setCustomerId(2244);
//        customer.setCustomerName("PumpkinTemple");
//        
//        cdao.createRecord(customer);
        
//        cdao.deleteRecord(1);
//        cdao.deleteRecord(2);
        
//        cdao.deleteRecord(1);
        
        System.out.println("Customer ID  ||| Customer Name");
        List<Customer> customerList = cdao.getAllCustomersHql();
        for(Customer customer : customerList) {
        	System.out.println("  "+customer.getCustomerId()+"              "+customer.getCustomerName());
        }
        
    }
}
