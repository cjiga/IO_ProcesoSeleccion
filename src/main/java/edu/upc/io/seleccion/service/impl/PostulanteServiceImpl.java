package edu.upc.io.seleccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.io.seleccion.dao.PostulanteDao;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.service.PostulanteService;

@Service("postulanteService")
public class PostulanteServiceImpl implements PostulanteService{
	@Autowired
	private PostulanteDao postulanteDao;

	public int save(Postulante postulante) {
		// TODO Auto-generated method stub
		return postulanteDao.save(postulante);
	}

	public int update(Postulante postulante) {
		// TODO Auto-generated method stub
		return postulanteDao.update(postulante);
	}

	public int delete(Postulante postulante) {
		// TODO Auto-generated method stub
		return postulanteDao.delete(postulante);
	}

	public Postulante getPostulante(Integer id) {
		// TODO Auto-generated method stub
		return postulanteDao.getPostulante(id);
	}

	public List<Postulante> getAll() {
		// TODO Auto-generated method stub
		return postulanteDao.getAll();
	}
}
