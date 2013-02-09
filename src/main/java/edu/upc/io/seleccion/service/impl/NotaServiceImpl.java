package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.io.seleccion.dao.NotaDao;
import edu.upc.io.seleccion.dao.PruebaDao;
import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.service.NotaService;

@Service("notaService")
public class NotaServiceImpl implements NotaService{

protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private NotaDao notaDao;
	
	@Override
	public List<Nota> getAll() {		
		return notaDao.getAll();
	}
	
}
