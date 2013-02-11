package edu.upc.io.seleccion.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Puesto;
import edu.upc.io.seleccion.service.PostulanteService;
import edu.upc.io.seleccion.service.PuestoService;
import edu.upc.io.seleccion.service.impl.PuestoServiceImpl;

@ManagedBean(name="puestoBean")
@SessionScoped 
public class PuestoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private PuestoService puestoService=new PuestoServiceImpl();
	
	private Puesto puesto=new Puesto();
	private List<Puesto> lstPuesto=new ArrayList<Puesto>();
	
	public PuestoBean(){
		System.out.println("Constructor Puesto Bean");
		lstPuesto.addAll(getPuestos());
	}
	
	
	public List<Puesto> getPuestos(){
		return puestoService.getAll();
	}
	public void prepararInsertar(){
		System.out.println("Prepara Insertar");
		puesto=new Puesto();
	}
	
	public void insertar(){
	
		puestoService.save(puesto);
		lstPuesto=getPuestos();
		System.out.println("Insertar");

		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Puesto guardado exitosamente.",""));
        prepararInsertar();
	}
	
	public void editar(){
		
		
		puestoService.update(puesto);
		lstPuesto=getPuestos();
		
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Postulante se actualizo exitosamente.",""));
        
	}
	
	public void eliminar(){
				
		puestoService.delete(puesto);
		lstPuesto=getPuestos();
		
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Postulante eliminado.",""));
        
	}
	/*Metodos Get y Set*/


	public List<Puesto> getLstPuesto() {
		return lstPuesto;
	}

	public void setLstPuesto(List<Puesto> lstPuesto) {
		this.lstPuesto = lstPuesto;
	}
	
	public PuestoService getPuestoService() {
		return puestoService;
	}

	public void setPuestoService(PuestoService puestoService) {
		this.puestoService = puestoService;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	
	
	
	
	
}
