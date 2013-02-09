package edu.upc.io.seleccion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="postulante")
public class Postulante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer idPostulante;
	private String descripcion;

	public Integer getIdPostulante() {
		return idPostulante;
	}
	public void setIdPostulante(Integer idPostulante) {
		this.idPostulante = idPostulante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
