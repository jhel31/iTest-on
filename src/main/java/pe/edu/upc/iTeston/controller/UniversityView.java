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

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;


@Named("universityView")
@ViewScoped
public class UniversityView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<University> universities;
	private University universitySelected;
	private List<University> universitiesSelected;
	private University universitySearch;
	
	@Inject
	private UniversityService universityService;

	@PostConstruct
	public void init() {
		universitiesSelected = new ArrayList<>();
		try {
			universities = universityService.getAll();
			universitySearch =  new University();
			getAllUniversity();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNew() {
		universitySelected = new University();
	}

	public void editUniversitySelected() {
		universitySelected = universitiesSelected.get(0);
	}

	public void saveUniversity() {
		try {
			if (universitySelected.getId() == null) {
				universityService.create(universitySelected);
				universities.add(universitySelected);
			} 
			else {
				universityService.update(universitySelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('universityDialog').hide()");
        PrimeFaces.current().ajax().update("universityDataTable");
	}
	
	public void deleteUniversity() {
		try {
			this.universities.remove(universitySelected);
			universityService.deleteById(this.universitySelected.getId());
			this.universitySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}
	
	public void searchUniversity() {
		try {
			universities = universityService.findByName(universitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllUniversity() {
		try {
			universities = universityService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get and sets
	public List<University> getUniversities() {
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

	public University getUniversitySelected() {
		return universitySelected;
	}

	public void setUniversitySelected(University universitySelected) {
		this.universitySelected = universitySelected;
	}

	public List<University> getUniversitiesSelected() {
		return universitiesSelected;
	}

	public void setUniversitiesSelected(List<University> universitiesSelected) {
		this.universitiesSelected = universitiesSelected;
	}

	public UniversityService getUniversityService() {
		return universityService;
	}

	public void setUniversityService(UniversityService universityService) {
		this.universityService = universityService;
	}

	public University getUniversitySearch() {
		return universitySearch;
	}

	public void setUniversitySearch(University universitySearch) {
		this.universitySearch = universitySearch;
	}
}
