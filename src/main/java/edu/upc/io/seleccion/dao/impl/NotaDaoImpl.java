package edu.upc.io.seleccion.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.domain.Prueba;

public class NotaDaoImpl implements NotaDao{

	@Override
	public int saveOrUpdate(Nota nota) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.saveOrUpdate(nota);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en insertar genero: " + e.getMessage());
		}
		return var;
	}
	
	protected static Logger logger = Logger.getLogger("PruebaDaoImpl");

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true) 
	public List<Nota> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Nota");
		return query.list();
	}

}
