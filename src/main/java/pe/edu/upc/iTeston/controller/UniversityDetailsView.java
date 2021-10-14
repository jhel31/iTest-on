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

import pe.edu.upc.iTeston.business.crud.UniversityDetailService;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;

@Named("universityDetailView")
@ViewScoped
public class UniversityDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<UniversityDetail> universitiesDetails;
	private UniversityDetail universityDetailSelected;
	private List<UniversityDetail> universitiesDetailsSelected;
	private UniversityDetail universityDetailSearch;
	@Inject
	private UniversityDetailService universityDetailsService;
	
	@PostConstruct
	public void init() {
		universitiesDetails = new ArrayList<>();
		try {
			universitiesDetails = universityDetailsService.getAll();
			universityDetailSearch = new UniversityDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNew() {
		universityDetailSelected = new UniversityDetail();		
	}
	
	public void editUniversityDetailSelected() {
		universityDetailSelected = universitiesDetailsSelected.get(0);
	}
	
	public void saveUniversityDetail() {
		try {
			if (universityDetailSelected.getId() == null) {
				universityDetailsService.create(universityDetailSelected);
				universitiesDetails.add(universityDetailSelected);
			} 
			else {
				universityDetailsService.update(universityDetailSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('universityDetailDialog').hide()");
        PrimeFaces.current().ajax().update("universityDetailDataTable");
	}
	
	
	public void deleteUniversityDetail() {
		try {
			this.universitiesDetails.remove(universityDetailSelected);
			universityDetailsService.deleteById(this.universityDetailSelected.getId());
			this.universityDetailSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
	}

	public List<UniversityDetail> getUniversitiesDetails() {
		return universitiesDetails;
	}

	public void setUniversitiesDetails(List<UniversityDetail> universitiesDetails) {
		this.universitiesDetails = universitiesDetails;
	}

	public UniversityDetail getUniversityDetailSelected() {
		return universityDetailSelected;
	}

	public void setUniversityDetailSelected(UniversityDetail universityDetailSelected) {
		this.universityDetailSelected = universityDetailSelected;
	}

	public List<UniversityDetail> getUniversitiesDetailsSelected() {
		return universitiesDetailsSelected;
	}

	public void setUniversitiesDetailsSelected(List<UniversityDetail> universitiesDetailsSelected) {
		this.universitiesDetailsSelected = universitiesDetailsSelected;
	}

	public UniversityDetail getUniversityDetailSearch() {
		return universityDetailSearch;
	}

	public void setUniversityDetailSearch(UniversityDetail universityDetailSearch) {
		this.universityDetailSearch = universityDetailSearch;
	}

	public UniversityDetailService getUniversityDetailsService() {
		return universityDetailsService;
	}

	public void setUniversityDetailsService(UniversityDetailService universityDetailsService) {
		this.universityDetailsService = universityDetailsService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
