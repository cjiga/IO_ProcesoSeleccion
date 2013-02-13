package edu.upc.io.seleccion.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.util.HibernateUtil;



public class PruebaDaoImpl implements PruebaDao{

	protected static Logger logger = Logger.getLogger("PruebaDaoImpl");

	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	@SuppressWarnings("unchecked")
	public List<Prueba> getAll() {
		System.out.println("DOA-get All");
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Prueba");
		List<Prueba> result=query.list();
		t.commit();
		return result;
	}

	public Prueba getPrueba(Integer id) {
		return (Prueba)session.get(Prueba.class, id);
	}

}
