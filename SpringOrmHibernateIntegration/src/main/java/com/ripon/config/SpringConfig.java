package com.ripon.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.ripon.doa.CustomerDao;
import com.ripon.doa.CustomerDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.ripon.*")
public class SpringConfig {

	// Jndi datasource bean for Glassfish server
	@Bean
	public DataSource getJndiDataSource(){ 

		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();	

		jndi.setJndiName("Spring8AM");

		Properties p = new Properties();
		p.setProperty("java.naming.factory.initial","com.sun.enterprise.naming.impl.SerialInitContextFactory");
		p.setProperty("java.naming.provider.url"," iiop://localhost:4848");

		jndi.setJndiEnvironment(p);

		DataSource ds = (DataSource)jndi;
		return ds;
		}
	
	
	//LocalSessionFactory bean created.
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getJndiDataSource());
		sf.setPackagesToScan("com.ripon.entities");
		
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.setProperty("hibernate.show_sql", "true");
		
		sf.setHibernateProperties(p);
		return sf;
	}
	
	//HibernateTemplate bean is created.
	@Bean
	public HibernateTemplate gethibernateTemplate() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory((SessionFactory) getLocalSessionFactoryBean());
		return ht;
	}
	
	//HibernateTransactionManager bean created. It takes care of transaction management.
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory((SessionFactory) getLocalSessionFactoryBean());
		return htm;
	}
	
	// CustomerDao bean created
	@Bean
	public CustomerDao getCustomerDao() {
		CustomerDaoImpl cd = new CustomerDaoImpl();
		cd.setHibernateTemplate(gethibernateTemplate());
		return cd;
	}
	
	
	
}
