package edu.upc.io.seleccion.service;

import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;

import edu.upc.io.seleccion.domain.Prueba;

@WebService
public interface PruebaService {

	@WebResult(name="getAll")
	public List<Prueba> getAll();
	
}
