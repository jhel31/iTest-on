package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;

@Named("careerView")
@ViewScoped
public class careerView implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Career> careers;
	private Career careerSelected;
	private List<Career> careersSelected;
	private Career careerSearch;
	
	@Inject
	private CareerService careerService;
	
	@PostConstruct
	public void init() {
		careersSelected = new ArrayList<>();
		try {
			careers = careerService.getAll();
			careerSearch = new Career();
			getAllCareer();
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
			if (careerSelected.getId() == null) {
				careerService.create(careerSelected);
				careers.add(careerSelected);
			} 
			else {
				careerService.update(careerSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		PrimeFaces.current().executeScript("PF('careerDialog').hide()");
        PrimeFaces.current().ajax().update("careerDataTable");
	}

	public void deleteCareer() {
		try {
			this.careers.remove(careerSelected);
			careerService.deleteById(this.careerSelected.getId());
			this.careerSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}
	
	public void searchCareer() {
		try {
			careers = careerService.findByName(careerSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllCareer() {
		try {
			careers = careerService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//get and sets
	
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

	public Career getCareerSearch() {
		return careerSearch;
	}

	public void setCareerSearch(Career careerSearch) {
		this.careerSearch = careerSearch;
	}

}
