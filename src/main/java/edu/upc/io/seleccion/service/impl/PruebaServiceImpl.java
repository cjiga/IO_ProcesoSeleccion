package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.dao.impl.NotaDaoImpl;
import edu.upc.io.seleccion.dao.impl.PruebaDaoImpl;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.service.PruebaService;



public class PruebaServiceImpl implements PruebaService{

	protected static Logger logger = Logger.getLogger("service");
	
	
	private PruebaDao pruebaDao;
	
	public PruebaServiceImpl(){
		pruebaDao=new PruebaDaoImpl();
	}
	
	public List<Prueba> getAll() {		
		return pruebaDao.getAll();
	}

	public Prueba getPrueba(Integer id) {
		return pruebaDao.getPrueba(id);
	}

}
