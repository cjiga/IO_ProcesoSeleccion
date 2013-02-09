package edu.upc.io.seleccion.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.service.NotaService;

@ManagedBean(name="notaController")
@SessionScoped
public class IngresoNotasController {

	@Autowired
	private NotaService notaService;
	private Nota nota;
	private List<Nota> lstNota;
	
	public IngresoNotasController(){
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
