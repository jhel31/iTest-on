package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;

public class UniversityView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<University> universities;
	private University universitySelected;
	private List<University> universitiesSelected;

	@Inject
	private UniversityService universityService;  
	
	@PostConstruct
	public void init() {
		universitiesSelected = new ArrayList<>();
		try {
			universities = universityService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//get and sets
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
}
