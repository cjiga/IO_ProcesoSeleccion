package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import edu.upc.io.seleccion.dao.PuntajeDao;
import edu.upc.io.seleccion.dao.impl.PuntajeDaoImpl;
import edu.upc.io.seleccion.domain.Puntaje;
import edu.upc.io.seleccion.service.PuntajeService;

public class PuntajeServiceImpl implements PuntajeService{

	protected static Logger logger = Logger.getLogger("service");
	private PuntajeDao puntajeDao = new PuntajeDaoImpl();
	
	public int saveOrUpdate(Puntaje puntaje) {
		return puntajeDao.saveOrUpdate(puntaje);
	}

	public List<Puntaje> getAll() {
		return puntajeDao.getAll();
	}

	public int delete() {
		return puntajeDao.delete();
	}

}
