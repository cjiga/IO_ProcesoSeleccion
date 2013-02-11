package edu.upc.io.seleccion.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.domain.Prueba;



public class PruebaDaoImpl implements PruebaDao{

	protected static Logger logger = Logger.getLogger("PruebaDaoImpl");

	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	
	public List<Prueba> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Prueba");
		return query.list();
	}

}
