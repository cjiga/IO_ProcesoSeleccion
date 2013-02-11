package edu.upc.io.seleccion.service.impl;

import java.util.List;

import edu.upc.io.seleccion.dao.PuestoDao;
import edu.upc.io.seleccion.dao.impl.PuestoDaoImpl;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;
import edu.upc.io.seleccion.service.PuestoService;


public class PuestoServiceImpl implements PuestoService{
	
	
	private PuestoDao puestoDao;

	public PuestoServiceImpl(){
		puestoDao=new PuestoDaoImpl();
	}
	public int save(Puesto puesto) {
		// TODO Auto-generated method stub
		return puestoDao.save(puesto);
	}

	public int update(Puesto puesto) {
		// TODO Auto-generated method stub
		return puestoDao.update(puesto);
	}

	public int delete(Puesto puesto) {
		// TODO Auto-generated method stub
		return puestoDao.delete(puesto);
	}

	public Postulante getPuesto(Integer id) {
		// TODO Auto-generated method stub
		return puestoDao.getPuesto(id);
	}

	public List<Puesto> getAll() {
		// TODO Auto-generated method stub
		return puestoDao.getAll();
	}

	public void setPuestoDao(PuestoDao puestoDao) {
		this.puestoDao = puestoDao;
	}
	
	

}
