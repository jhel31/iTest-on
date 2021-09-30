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

@Named("CarreerView")
@ViewScoped
public class CarreerView implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Career> Careers;
	private Career CareerSelected;
	private List<Career> CareersSelected;
	
	@Inject
	private CareerService CareerService;
	@PostConstruct
	public void init() {
		CareersSelected = new ArrayList<>();
		try {
			Careers = CareerService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void createNew() {
		CareerSelected = new Career();		
	}
	public void editCareerSelected() {
		CareerSelected = CareersSelected.get(0);
	}
	
	public void saveCareer() {
		try {
			CareerService.create(CareerSelected);
			Careers.add(CareerSelected);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('CareerDialog').hide()");
		PrimeFaces.current().ajax().update("form:CareerDataTable");
	
	}
	
	public List<Career> getCareers() {
		return Careers;
	}
	public void setCareers(List<Career> careers) {
		Careers = careers;
	}
	public Career getCareerSelected() {
		return CareerSelected;
	}
	public void setCareerSelected(Career careerSelected) {
		CareerSelected = careerSelected;
	}
	public List<Career> getCareersSelected() {
		return CareersSelected;
	}
	public void setCareersSelected(List<Career> careersSelected) {
		CareersSelected = careersSelected;
	}
	public CareerService getCareerService() {
		return CareerService;
	}
	public void setCareerService(CareerService careerService) {
		CareerService = careerService;
	}
	
	
	
}
