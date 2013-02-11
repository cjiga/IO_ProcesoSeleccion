package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.domain.Nota;


public class NotaDaoImpl implements NotaDao{
	
	
	private SessionFactory sessionFactory;

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
	
	
	@SuppressWarnings("unchecked")
	public List<Nota> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Nota");
		return query.list();
	}

}
