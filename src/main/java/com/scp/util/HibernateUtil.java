package com.scp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionfact;
	public static SessionFactory getSessionFactory(){
		if(sessionfact==null){
		 	Configuration config=new Configuration();
		 	sessionfact=config.configure("/hibernate.cfg.xml").buildSessionFactory();
			
		}
		return sessionfact;
}
}
