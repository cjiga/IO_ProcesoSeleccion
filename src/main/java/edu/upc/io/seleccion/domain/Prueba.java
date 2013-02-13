package edu.upc.io.seleccion.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prueba database table.
 * 
 */
@Entity
public class Prueba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idprueba;

	private String descripcion;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="prueba")
	private List<Nota> notas;

	//bi-directional many-to-one association to Peso
	@OneToMany(mappedBy="prueba")
	private List<Peso> pesos;

	public Prueba() {
	}

	public Integer getIdprueba() {
		return this.idprueba;
	}

	public void setIdprueba(Integer idprueba) {
		this.idprueba = idprueba;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Peso> getPesos() {
		return this.pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}

	@Override
	public String toString() {
		return "Prueba [idprueba=" + idprueba + ", descripcion=" + descripcion + "]";
	}
}