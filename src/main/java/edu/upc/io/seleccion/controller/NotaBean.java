package edu.upc.io.seleccion.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.service.NotaService;

@ManagedBean(name="notaBean")
@SessionScoped
public class NotaBean {

	private NotaService notaService;
	private Nota nota;
	private List<Nota> lstNota;
	
	public NotaBean(){
		nota=new Nota();
		lstNota=notaService.getAll();
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public List<Nota> getLstNota() {
		return lstNota;
	}

	public void setLstNota(List<Nota> lstNota) {
		this.lstNota = lstNota;
	}
	
}
