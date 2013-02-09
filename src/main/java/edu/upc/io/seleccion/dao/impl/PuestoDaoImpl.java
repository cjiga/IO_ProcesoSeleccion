package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.io.seleccion.dao.PuestoDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;

@Repository("puestoDao")
@Transactional
public class PuestoDaoImpl implements PuestoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public int save(Puesto puesto) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.save(puesto);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en insertar genero: " + e.getMessage());
		}
		return var;
	}

	public int update(Puesto puesto) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.update(puesto);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en actualizar genero: " + e.getMessage());
		}
		return var;
	}

	public int delete(Puesto puesto) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.delete(puesto);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en eliminar genero: " + e.getMessage());
		}
		return var;
	}
	
	@Transactional(readOnly = true) 
	public Postulante getPuesto(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Postulante)session.get(Postulante.class, id);
	}
	
	@Transactional(readOnly = true) 
	public List<Puesto> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Puesto");
		return query.list();
	}

}
