package edu.upc.io.seleccion.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="peso")
public class Peso {

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idPuesto")
	private Puesto puesto;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idPrueba")
	private Prueba prueba;

	private double peso;
	
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public Prueba getPrueba() {
		return prueba;
	}
	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
