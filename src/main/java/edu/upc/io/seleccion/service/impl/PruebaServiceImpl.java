package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.service.PruebaService;

@Service("pruebaService")
public class PruebaServiceImpl implements PruebaService{

	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private PruebaDao pruebaDao;
	
	@Override
	public List<Prueba> getAll() {		
		return pruebaDao.getAll();
	}

}
