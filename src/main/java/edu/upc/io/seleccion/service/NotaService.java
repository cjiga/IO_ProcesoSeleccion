package edu.upc.io.seleccion.service;

import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;

import edu.upc.io.seleccion.domain.Nota;

public interface NotaService {

	List<Nota> getAll();
	int saveOrUpdate(Nota nota);
	public int delete(Nota nota);
}
