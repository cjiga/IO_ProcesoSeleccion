package edu.upc.io.seleccion.dao;

import java.util.List;

import edu.upc.io.seleccion.domain.Nota;

public interface NotaDao {

	
	public int saveOrUpdate(Nota nota);
	public List<Nota> getAll();
	public int delete(Nota nota);
	
}
