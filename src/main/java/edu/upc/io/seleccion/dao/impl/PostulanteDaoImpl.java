package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.io.seleccion.dao.PostulanteDao;
import edu.upc.io.seleccion.domain.Postulante;

@Repository("postulanteDao")
@Transactional
public class PostulanteDaoImpl implements PostulanteDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public int save(Postulante postulante) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.save(postulante);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en insertar genero: " + e.getMessage());
		}
		return var;
	}

	public int update(Postulante postulante) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.update(postulante);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en actualizar genero: " + e.getMessage());
		}
		return var;
	}
	
	public int delete(Postulante postulante) {
		Session session = sessionFactory.getCurrentSession();
		int var=0;
		try {
			session.delete(postulante);
			var=1;
		} catch (Exception e) {
			System.out.println("Error en eliminar genero: " + e.getMessage());
		}
		return var;
	}
	
	@Transactional(readOnly = true)
	public Postulante getPostulante(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Postulante)session.get(Postulante.class, id);
	}
	
	@Transactional(readOnly = true)
	public List<Postulante> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Postulante");
		return query.list();
	}

}
