package edu.upc.io.seleccion.dao;

import java.util.List;

import edu.upc.io.seleccion.domain.Puntaje;

public interface PuntajeDao {

	public int saveOrUpdate(Puntaje puntaje);
	public List<Puntaje> getAll();
	public int delete();
	
}
