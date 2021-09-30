package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;

@Named("careerView")
@ViewScoped
public class CarreerView implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Career> careers;
	private Career careerSelected;
	private List<Career> careersSelected;
	
	@Inject
	private CareerService careerService;
	@PostConstruct
	public void init() {
		careersSelected = new ArrayList<>();
		try {
			careers = careerService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void createNew() {
		careerSelected = new Career();		
	}
	public void editCareerSelected() {
		careerSelected = careersSelected.get(0);
	}
	
	public void saveCareer() {
		try {
			careerService.create(careerSelected);
			careers.add(careerSelected);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('careerDialog').hide()");
		PrimeFaces.current().ajax().update("form:careerDataTable");
	
	}

	
	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	public Career getCareerSelected() {
		return careerSelected;
	}

	public void setCareerSelected(Career careerSelected) {
		this.careerSelected = careerSelected;
	}

	public List<Career> getCareersSelected() {
		return careersSelected;
	}

	public void setCareersSelected(List<Career> careersSelected) {
		this.careersSelected = careersSelected;
	}

	public CareerService getCareerService() {
		return careerService;
	}

	public void setCareerService(CareerService careerService) {
		this.careerService = careerService;
	}

}
