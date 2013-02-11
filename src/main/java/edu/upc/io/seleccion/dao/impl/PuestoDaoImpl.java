package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.PuestoDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;
import edu.upc.io.seleccion.util.HibernateUtil;



public class PuestoDaoImpl implements PuestoDao{
	
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	public int save(Puesto puesto) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.save(puesto);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en insertar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}

	public int update(Puesto puesto) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.update(puesto);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en actualizar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}

	public int delete(Puesto puesto) {
		Transaction t = session.beginTransaction();
		int var=0;
		try {
			session.delete(puesto);
			t.commit();
			var=1;
		} catch (Exception e) {
			System.out.println("Error en eliminar genero: " + e.getMessage());
			t.rollback();
		}
		return var;
	}
	
	public Postulante getPuesto(Integer id) {
		return (Postulante)session.get(Postulante.class, id);
	}
	
	public List<Puesto> getAll() {
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Puesto");
		List<Puesto> lstPuesto=query.list();
		t.commit();
		return query.list();
	}

}
