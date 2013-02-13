package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.PesoDao;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.domain.Peso;
import edu.upc.io.seleccion.util.HibernateUtil;

public class PesoDaoImpl implements PesoDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	public int saveOrUpdate(Peso peso) {
		Transaction t = session.beginTransaction();
		int var = 0;
		try {
			session.saveOrUpdate(peso);
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en insertar peso: " + e.getMessage());
		}
		return var;
	}

	public List<Peso> getAll(int idpuesto) {
		Query query = session
				.createQuery("select p from Peso p where p.puesto.idpuesto = :id");
		query.setParameter("id", idpuesto);
		List<Peso> result = query.list();
		return result;
	}

	public int delete(int idpuesto) {
		Transaction t = session.beginTransaction();
		int var = 0;

		try {
			Query query = session
					.createQuery("DELETE FROM Peso p WHERE p.puesto.idpuesto = :id");
			query.setParameter("id", idpuesto);
			query.executeUpdate();
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en eliminando puesto: " + e.getMessage());
		}
		return var;
	}
}
