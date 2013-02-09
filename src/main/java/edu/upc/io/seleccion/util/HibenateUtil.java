package edu.upc.io.seleccion.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibenateUtil {
	
	@Autowired
	private static final SessionFactory sessionFactory;
	
	static{
		try {
			sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Initial SessionFactory creation failed" + e);
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
