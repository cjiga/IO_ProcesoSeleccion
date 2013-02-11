package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.PostulanteDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.util.HibernateUtil;



public class PostulanteDaoImpl implements PostulanteDao{
	
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public int save(Postulante postulante) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.save(postulante);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en insertar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}

	public int update(Postulante postulante) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.update(postulante);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en actualizar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}
	
	public int delete(Postulante postulante) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.delete(postulante);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en eliminar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}
	
	public Postulante getPostulante(Integer id) {
		return (Postulante)session.get(Postulante.class, id);
	}
	
	public List<Postulante> getAll() {
		System.out.println("DOA-get All");
		Transaction t = session.beginTransaction();
		//Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Postulante");
		List<Postulante> lstPostulante=query.list();
		t.commit();
		return lstPostulante;
	}

	

	
	

}
