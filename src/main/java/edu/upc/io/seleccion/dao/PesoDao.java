package edu.upc.io.seleccion.dao;

import java.util.List;

import edu.upc.io.seleccion.domain.Peso;

public interface PesoDao {

	public int saveOrUpdate(Peso peso);
	public List<Peso> getAll(int idpuesto);
	public int delete(int idpuesto);
	
}
