package com.ripon.hibe.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

	private static SessionFactory sf = cfg.buildSessionFactory();
	
	// returns session factory object
	public static Session getSessionObject() {
		return sf.openSession();
	}
	
}
