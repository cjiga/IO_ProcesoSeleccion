package edu.upc.io.seleccion.service;

import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;

import edu.upc.io.seleccion.domain.Prueba;

public interface PruebaService {

	public List<Prueba> getAll();
	public Prueba getPrueba(Integer id);
	
}
