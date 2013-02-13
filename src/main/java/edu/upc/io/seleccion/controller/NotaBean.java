package edu.upc.io.seleccion.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.service.NotaService;
import edu.upc.io.seleccion.service.PostulanteService;
import edu.upc.io.seleccion.service.PruebaService;
import edu.upc.io.seleccion.service.impl.NotaServiceImpl;
import edu.upc.io.seleccion.service.impl.PostulanteServiceImpl;
import edu.upc.io.seleccion.service.impl.PruebaServiceImpl;

@ManagedBean(name="notaBean")
@SessionScoped
public class NotaBean {

	private NotaService notaService = new NotaServiceImpl();
	private PruebaService pruebaService = new PruebaServiceImpl();
	private PostulanteService postulanteService = new PostulanteServiceImpl();
	private Nota nota;
	private List<Nota> lstNota;
	private List<Prueba> lstPrueba;
	private List<Postulante> lstPostulante;	
	
	public NotaBean(){
		nota=new Nota();
		nota.setPostulante(new Postulante());
		nota.setPrueba(new Prueba());
		lstNota=notaService.getAll();
		lstPrueba = pruebaService.getAll();
		lstPostulante = postulanteService.getAll();
	}
	
	public void prepararInsertar(){
		nota=new Nota();
		nota.setPostulante(new Postulante());
		nota.setPrueba(new Prueba());		
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

	public List<Prueba> getLstPrueba() {
		return lstPrueba;
	}

	public List<Postulante> getLstPostulante() {
		return lstPostulante;
	}
	
	public void insertar(){
		notaService.delete(nota);
		System.out.println("Probando" + nota);
		Nota n = new Nota();		
		n.setPostulante(postulanteService.getPostulante(nota.getPostulante().getIdpostulante()));
		n.setPrueba(pruebaService.getPrueba(nota.getPrueba().getIdprueba()));
		n.setPuntaje(nota.getPuntaje());
		notaService.saveOrUpdate(n);
		lstNota=notaService.getAll();	
	}
	
	public void eliminar(){
		System.out.println("Probando" + nota);
		notaService.delete(nota);		
		lstNota=notaService.getAll();	
	}
	
	
}
