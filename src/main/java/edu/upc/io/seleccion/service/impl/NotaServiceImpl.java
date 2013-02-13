package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.dao.impl.NotaDaoImpl;
import edu.upc.io.seleccion.dao.impl.PostulanteDaoImpl;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.service.NotaService;


public class NotaServiceImpl implements NotaService{

	protected static Logger logger = Logger.getLogger("service");

	private NotaDao notaDao;

	public NotaServiceImpl(){
		notaDao=new NotaDaoImpl();
	}
	
	public List<Nota> getAll() {		
		return notaDao.getAll();
	}

	public int saveOrUpdate(Nota nota) {
		return notaDao.saveOrUpdate(nota);
		
	}

	public int delete(Nota nota) {
		return notaDao.delete(nota);
	}
	
	
}
