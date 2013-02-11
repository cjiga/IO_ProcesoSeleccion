package edu.upc.io.seleccion.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the postulante database table.
 * 
 */
@Entity
public class Postulante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idpostulante;

	private String descripcion;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="postulante")
	private List<Nota> notas;

	public Postulante() {
	}

	public String getIdpostulante() {
		return this.idpostulante;
	}

	public void setIdpostulante(String idpostulante) {
		this.idpostulante = idpostulante;
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

}