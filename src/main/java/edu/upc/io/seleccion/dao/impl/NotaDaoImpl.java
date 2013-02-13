package edu.upc.io.seleccion.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.util.HibernateUtil;

public class NotaDaoImpl implements NotaDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	public int saveOrUpdate(Nota nota) {
		Transaction t = session.beginTransaction();
		int var = 0;
		try {
			session.saveOrUpdate(nota);
			session.flush();
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en insertar nota: " + e.getMessage());
		}
		return var;
	}

	@SuppressWarnings("unchecked")
	public List<Nota> getAll() {
		Query query = session
				.createQuery("select n from Nota n join fetch n.prueba join fetch n.postulante");
		List<Nota> result = query.list();
		return result;
	}

	public int delete(Nota nota) {

		Transaction t = session.beginTransaction();
		int var = 0;

		try {
			Query query = session
					.createQuery("DELETE FROM Nota n WHERE n.postulante.idpostulante = :p and n.prueba.idprueba = :p2");
			query.setParameter("p", nota.getPostulante().getIdpostulante());
			query.setParameter("p2", nota.getPrueba().getIdprueba());
			query.executeUpdate();
			session.flush();
			t.commit();
			var = 1;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error en insertar nota: " + e.getMessage());
		}
		return var;
	}

}
