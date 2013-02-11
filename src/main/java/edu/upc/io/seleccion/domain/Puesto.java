package edu.upc.io.seleccion.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the puesto database table.
 * 
 */
@Entity
public class Puesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idpuesto;

	private String descripcion;

	private BigInteger preferencia;

	//bi-directional many-to-one association to Peso
	@OneToMany(mappedBy="puesto")
	private List<Peso> pesos;

	public Puesto() {
	}

	public String getIdpuesto() {
		return this.idpuesto;
	}

	public void setIdpuesto(String idpuesto) {
		this.idpuesto = idpuesto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigInteger getPreferencia() {
		return this.preferencia;
	}

	public void setPreferencia(BigInteger preferencia) {
		this.preferencia = preferencia;
	}

	public List<Peso> getPesos() {
		return this.pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}

}