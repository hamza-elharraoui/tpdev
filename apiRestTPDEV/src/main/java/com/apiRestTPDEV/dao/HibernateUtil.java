package com.apiRestTPDEV.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static{
		try{
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex){
			System.err.println("Echec creation sessionFactory "+ex);
			throw new ExceptionInInitializerError();
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
