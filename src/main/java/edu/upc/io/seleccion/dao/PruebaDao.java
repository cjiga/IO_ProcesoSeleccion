package edu.upc.io.seleccion.dao;

import java.util.List;

import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Prueba;

public interface PruebaDao {

	public List<Prueba> getAll();
	public Prueba getPrueba(Integer id);
	
}
