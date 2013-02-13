package edu.upc.io.seleccion.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the peso database table.
 * 
 */
@Entity
public class Peso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idpeso;

	private double porcentaje;

	//bi-directional many-to-one association to Prueba
	@ManyToOne
	@JoinColumn(name="idprueba")
	private Prueba prueba;

	//bi-directional many-to-one association to Puesto
	@ManyToOne
	@JoinColumn(name="idpuesto")
	private Puesto puesto;

	public Peso() {
	}

	public Integer getIdpeso() {
		return this.idpeso;
	}

	public void setIdpeso(Integer idpeso) {
		this.idpeso = idpeso;
	}

	public double getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Prueba getPrueba() {
		return this.prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

	public Puesto getPuesto() {
		return this.puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

}