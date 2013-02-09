package edu.upc.io.seleccion.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.domain.Prueba;

@Repository("pruebaDao")
@Transactional
public class PruebaDaoImpl implements PruebaDao{

	protected static Logger logger = Logger.getLogger("PruebaDaoImpl");

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true) 
	public List<Prueba> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Prueba");
		return query.list();
	}

}
