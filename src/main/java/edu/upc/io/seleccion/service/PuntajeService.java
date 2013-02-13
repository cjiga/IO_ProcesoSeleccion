package edu.upc.io.seleccion.service;

import java.util.List;

import edu.upc.io.seleccion.domain.Puntaje;

public interface PuntajeService {

	public int saveOrUpdate(Puntaje puntaje);
	public List<Puntaje> getAll();
	public int delete();
}
