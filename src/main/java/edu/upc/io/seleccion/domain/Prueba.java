package edu.upc.io.seleccion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prueba")
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer idPrueba;
	private String descripcion;

	public Integer getIdPrueba() {
		return idPrueba;
	}
	public void setIdPrueba(Integer idPrueba) {
		this.idPrueba = idPrueba;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
