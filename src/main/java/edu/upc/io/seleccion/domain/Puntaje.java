package edu.upc.io.seleccion.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Puntaje implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idpuntaje;

	private double puntaje;

	private String postulante;
	
	private String puesto;

	private double y;

	private double z;

	public Integer getIdpuntaje() {
		return idpuntaje;
	}

	public void setIdpuntaje(Integer idpuntaje) {
		this.idpuntaje = idpuntaje;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Puntaje [idpuntaje=" + idpuntaje + ", puntaje=" + puntaje
				+ ", postulante=" + postulante + ", puesto=" + puesto + ", y="
				+ y + ", z=" + z + "]";
	}
}
