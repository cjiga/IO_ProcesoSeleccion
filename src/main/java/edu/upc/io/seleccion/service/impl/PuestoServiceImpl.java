package edu.upc.io.seleccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.upc.io.seleccion.dao.PuestoDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;
import edu.upc.io.seleccion.service.PuestoService;

public class PuestoServiceImpl implements PuestoService{
	
	@Autowired
	private PuestoDao puestoDao;

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

}
