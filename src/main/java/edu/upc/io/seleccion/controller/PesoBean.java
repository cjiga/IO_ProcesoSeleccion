package edu.upc.io.seleccion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.upc.io.seleccion.domain.Peso;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.domain.Puesto;
import edu.upc.io.seleccion.service.PesoService;
import edu.upc.io.seleccion.service.PruebaService;
import edu.upc.io.seleccion.service.PuestoService;
import edu.upc.io.seleccion.service.impl.PesoServiceImpl;
import edu.upc.io.seleccion.service.impl.PruebaServiceImpl;
import edu.upc.io.seleccion.service.impl.PuestoServiceImpl;

@ManagedBean(name="pesoBean")
@SessionScoped
public class PesoBean {

	private PruebaService pruebaService = new PruebaServiceImpl();
	private PuestoService puestoService = new PuestoServiceImpl();
	private PesoService pesoService = new PesoServiceImpl();
	private List<Peso> lstPeso;
	private List<Puesto> lstPuesto;
	private Integer idpuesto;
	private Peso peso;
	
	public PesoBean(){
		lstPuesto =	puestoService.getAll();
		lstPeso = new ArrayList<Peso>();
		peso = new Peso();
	}

	public List<Puesto> getLstPuesto() {
		return lstPuesto;
	}

	public Integer getIdpuesto() {
		return idpuesto;
	}

	public void setIdpuesto(Integer idpuesto) {
		this.idpuesto = idpuesto;
	}
	
	public void cargar(){
		System.out.println(getIdpuesto());
		if(getIdpuesto()==null||getIdpuesto()==0){
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Seleccione Puesto.",""));								
		}else{
			Puesto p = puestoService.getPuesto(idpuesto);
			System.out.println(p);
			List<Prueba> lstPrueba = pruebaService.getAll();
			lstPeso = new ArrayList<Peso>();
			List<Peso> lstPesoAnterior = pesoService.getAll(idpuesto);
			for (Prueba prueba : lstPrueba) {
				double porcentaje = 0;
				if(lstPesoAnterior!=null){
					for (Peso peso : lstPesoAnterior) {
						if(peso.getPrueba().getIdprueba().equals(prueba.getIdprueba())){
							porcentaje = peso.getPorcentaje();
							break;
						}
					}					
				}
				
				Peso pe = new Peso();
				pe.setPuesto(p);
				pe.setPrueba(prueba);
				pe.setPorcentaje(porcentaje);
				System.out.println(prueba);
				lstPeso.add(pe);
			}
			System.out.println(isMostrar());
		}
	}

	public List<Peso> getLstPeso() {
		return lstPeso;
	}

	public void setLstPeso(List<Peso> lstPeso) {
		this.lstPeso = lstPeso;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}
	
	public boolean isMostrar(){
		return (idpuesto!=null&&idpuesto>0);		
	}
	
	public double getTotalPorcentaje(){
		double total = 0;
		if(lstPeso!=null)
			for (Peso p : lstPeso) {
				total+=p.getPorcentaje();
			}
		return total;
	}
	
	public void guardar(){
		if(getTotalPorcentaje()!=100){
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Suma total de porcentaje diferente de 100.",""));
	        return;
		}
		pesoService.delete(idpuesto);
		for (Peso peso : lstPeso) {
			pesoService.saveOrUpdate(peso);
		}
		idpuesto = 0;
	}
}
