package edu.upc.io.seleccion.service;

import java.util.List;

import edu.upc.io.seleccion.domain.Peso;

public interface PesoService {

	public int saveOrUpdate(Peso peso);
	public List<Peso> getAll(int idpuesto);
	public int delete(int idpuesto);
	
}
