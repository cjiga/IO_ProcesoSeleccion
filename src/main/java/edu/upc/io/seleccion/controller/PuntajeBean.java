package edu.upc.io.seleccion.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.upc.io.seleccion.domain.Nota;
import edu.upc.io.seleccion.domain.Peso;
import edu.upc.io.seleccion.domain.Postulante;
import edu.upc.io.seleccion.domain.Prueba;
import edu.upc.io.seleccion.domain.Puntaje;
import edu.upc.io.seleccion.service.PostulanteService;
import edu.upc.io.seleccion.service.PruebaService;
import edu.upc.io.seleccion.service.PuntajeService;
import edu.upc.io.seleccion.service.impl.PostulanteServiceImpl;
import edu.upc.io.seleccion.service.impl.PruebaServiceImpl;
import edu.upc.io.seleccion.service.impl.PuntajeServiceImpl;

@ManagedBean(name="puntajeBean")
@SessionScoped 
public class PuntajeBean {

	private PuntajeService puntajeService = new PuntajeServiceImpl();
	private PruebaService pruebaService = new PruebaServiceImpl();
	private List<Puntaje> lstPuntaje;
	
	public String cargarPuntaje(){
		this.lstPuntaje = new ArrayList<Puntaje>();
		puntajeService.delete();
		List<Puntaje> lstPuntaje = new ArrayList<Puntaje>();		
		List<Prueba> lstPrueba = pruebaService.getAll();
		HashMap<PostulantePuesto, Double> hm = new HashMap<PostulantePuesto, Double>();
		for (Prueba prueba : lstPrueba) {
			for (Peso peso : prueba.getPesos()) {
				for (Nota nota : prueba.getNotas()) {
					PostulantePuesto pp = new PostulantePuesto();
					pp.setPostulante(nota.getPostulante().getDescripcion());
					pp.setPuesto(peso.getPuesto().getDescripcion());
					if(hm.containsKey(pp)){
						hm.put(pp, hm.get(pp) + nota.getPuntaje()*peso.getPorcentaje()/100);		
					}else{
						hm.put(pp, nota.getPuntaje()*peso.getPorcentaje()/100);	
					}					
				}
			}
		}
		for (Entry<PostulantePuesto, Double> pp : hm.entrySet()) {
			Puntaje p = new Puntaje();
			p.setPostulante(pp.getKey().getPostulante());
			p.setPuesto(pp.getKey().getPuesto());
			p.setPuntaje(pp.getValue());
			System.out.println(p);
			lstPuntaje.add(p);
		}
		for (Puntaje puntaje : lstPuntaje) {
			puntajeService.saveOrUpdate(puntaje);
		}
		return "/pages/puntajes";
	}
	
	public void listar(){
		lstPuntaje = puntajeService.getAll();
	}
	
	public void solveLingo(){
		
	}

	public List<Puntaje> getLstPuntaje() {
		return lstPuntaje;
	}	
}

class PostulantePuesto{
	
	private String postulante;
	private String puesto;
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
	
	@Override
	public boolean equals(Object obj){
		if(obj==null||!(obj instanceof PostulantePuesto))
			return false;
		
		PostulantePuesto o = (PostulantePuesto)obj;
		return o.postulante.equals(postulante)&&o.puesto.equals(puesto);
	}
	
	@Override
	public int hashCode(){
		return this.postulante.hashCode() + this.puesto.hashCode();
	}
}
