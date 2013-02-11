package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.service.NotaService;


public class NotaServiceImpl implements NotaService{

protected static Logger logger = Logger.getLogger("service");
	
	
	private NotaDao notaDao;
	
	
	public List<Nota> getAll() {		
		return notaDao.getAll();
	}


	public NotaDao getNotaDao() {
		return notaDao;
	}


	public void setNotaDao(NotaDao notaDao) {
		this.notaDao = notaDao;
	}
	
	
}
