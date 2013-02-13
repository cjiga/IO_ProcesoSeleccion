package edu.upc.io.seleccion.service.impl;

import java.util.List;
import java.util.logging.Logger;

import edu.upc.io.seleccion.dao.PesoDao;
import edu.upc.io.seleccion.dao.impl.PesoDaoImpl;
import edu.upc.io.seleccion.domain.Peso;
import edu.upc.io.seleccion.service.PesoService;

public class PesoServiceImpl implements PesoService{

	protected static Logger logger = Logger.getLogger("service");

	private PesoDao pesoDao;
	
	public PesoServiceImpl(){
		pesoDao = new PesoDaoImpl();		
	}
	
	public int saveOrUpdate(Peso peso) {
		return pesoDao.saveOrUpdate(peso);
	}

	public List<Peso> getAll(int idpuesto) {
		return pesoDao.getAll(idpuesto);
	}

	public int delete(int idpuesto) {
		return pesoDao.delete(idpuesto);
	}

}
