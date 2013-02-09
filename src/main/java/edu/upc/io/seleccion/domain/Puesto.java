package edu.upc.io.seleccion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="puesto")
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer idPuesto;
	private String descripcion;
	private Integer preferencia;
	
	public Integer getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(Integer preferencia) {
		this.preferencia = preferencia;
	}
}