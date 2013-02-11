package edu.upc.io.seleccion.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the nota database table.
 * 
 */
@Entity
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idnota;

	private BigDecimal puntaje;

	//bi-directional many-to-one association to Postulante
	@ManyToOne
	@JoinColumn(name="idpostulante")
	private Postulante postulante;

	//bi-directional many-to-one association to Prueba
	@ManyToOne
	@JoinColumn(name="idprueba")
	private Prueba prueba;

	public Nota() {
	}

	public String getIdnota() {
		return this.idnota;
	}

	public void setIdnota(String idnota) {
		this.idnota = idnota;
	}

	public BigDecimal getPuntaje() {
		return this.puntaje;
	}

	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}

	public Postulante getPostulante() {
		return this.postulante;
	}

	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}

	public Prueba getPrueba() {
		return this.prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

}