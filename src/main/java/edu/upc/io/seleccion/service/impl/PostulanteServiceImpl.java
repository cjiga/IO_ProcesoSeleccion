package edu.upc.io.seleccion.service.impl;

import java.util.List;

import edu.upc.io.seleccion.dao.PostulanteDao;
import edu.upc.io.seleccion.dao.impl.PostulanteDaoImpl;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.service.PostulanteService;

public class PostulanteServiceImpl implements PostulanteService{
	
	private PostulanteDao postulanteDao;
	
	public PostulanteServiceImpl(){
		postulanteDao=new PostulanteDaoImpl();
	}

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
		System.out.println("Service-Get All");
		return postulanteDao.getAll();
	}

	public void setPostulanteDao(PostulanteDao postulanteDao) {
		this.postulanteDao = postulanteDao;
	}
	
	

	
}
