package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.PuntajeDao;
import edu.upc.io.seleccion.domain.Puntaje;
import edu.upc.io.seleccion.util.HibernateUtil;

public class PuntajeDaoImpl implements PuntajeDao{

	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public int saveOrUpdate(Puntaje puntaje) {
		Transaction t = session.beginTransaction();
		int var = 0;
		try {
			session.saveOrUpdate(puntaje);
			session.flush();
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en insertar puntaje: " + e.getMessage());
		}
		return var;
	}

	public List<Puntaje> getAll() {
		Query query = session
				.createQuery("from Puntaje");
		List<Puntaje> result = query.list();
		return result;
	}

	public int delete() {
		Transaction t = session.beginTransaction();
		int var = 0;

		try {
			Query query = session
					.createQuery("DELETE FROM Puntaje p");
			query.executeUpdate();
			session.flush();
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en eliminar puntaje: " + e.getMessage());
		}
		return var;
	}

}
