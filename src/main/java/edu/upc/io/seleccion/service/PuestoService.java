package edu.upc.io.seleccion.service;

import java.util.List;

import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;

public interface PuestoService {

	public int save(Puesto puesto);
	public int update(Puesto puesto);
	public int delete(Puesto puesto);
	public Puesto getPuesto(Integer id);
	public List<Puesto> getAll();
}
