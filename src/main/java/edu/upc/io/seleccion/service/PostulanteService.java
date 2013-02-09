package edu.upc.io.seleccion.service;

import java.util.List;

import edu.upc.io.seleccion.domain.Postulante;

public interface PostulanteService {
	
	public int save(Postulante postulante);
	public int update(Postulante postulante);
	public int delete(Postulante postulante);
	public Postulante getPostulante(Integer id);
	public List<Postulante> getAll();

}
