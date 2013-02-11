package edu.upc.io.seleccion.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.service.PostulanteService;
import edu.upc.io.seleccion.service.impl.PostulanteServiceImpl;

@ManagedBean(name="postulanteBean")
@SessionScoped 
public class PostulanteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private PostulanteService postulanteService=new PostulanteServiceImpl();
	
	private Postulante postulante=new Postulante();
	private List<Postulante> lstPostulante=new ArrayList<Postulante>();
	
	public PostulanteBean(){
		System.out.println("Constructor Postulante Bean");
		lstPostulante.addAll(getPostulantes());
	}
	
	
	public List<Postulante> getPostulantes(){
		return postulanteService.getAll();
	}
	public void prepararInsertar(){
		System.out.println("Prepara Insertar");
		postulante=new Postulante();
	}
	
	public void insertar(){
	
		postulanteService.save(postulante);
		lstPostulante=getPostulantes();
		System.out.println("Insertar");

		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Postulante guardado exitosamente.",""));
        prepararInsertar();
	}
	
	public void editar(){
		
		
		postulanteService.update(postulante);
		lstPostulante=getPostulantes();
		
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Postulante se actualizo exitosamente.",""));
        
	}
	
	public void eliminar(){
				
		postulanteService.delete(postulante);
		lstPostulante=getPostulantes();
		
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Postulante eliminado.",""));
        
	}
	/*Metodos Get y Set*/


	public List<Postulante> getLstPostulante() {
		return lstPostulante;
	}

	public void setLstPostulante(List<Postulante> lstPostulante) {
		this.lstPostulante = lstPostulante;
	}
	
	public PostulanteService getPostulanteService() {
		return postulanteService;
	}

	public void setPostulanteService(PostulanteService postulanteService) {
		this.postulanteService = postulanteService;
	}

	public Postulante getPostulante() {
		return postulante;
	}

	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}
	
	
	
	
	
}
