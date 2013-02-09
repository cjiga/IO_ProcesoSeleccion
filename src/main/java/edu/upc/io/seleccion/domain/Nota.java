package edu.upc.io.seleccion.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nota")
public class Nota {

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idPostulante")
	private Postulante postulante;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idPrueba")
	private Prueba prueba;

	private double nota;
	
	public Postulante getPostulante() {
		return postulante;
	}
	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}
	public Prueba getPrueba() {
		return prueba;
	}
	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
}
