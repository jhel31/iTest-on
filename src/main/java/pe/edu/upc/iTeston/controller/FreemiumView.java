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

import pe.edu.upc.iTeston.business.crud.FreemiumService;
import pe.edu.upc.iTeston.models.entities.Freemium;

@Named("freemiumView")
@ViewScoped
public class FreemiumView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Freemium freemiumSelected;
	
	private List<Freemium> freemiums;
	private List<Freemium> freemiumsSelected;

	@Inject
	private FreemiumService freemiumService;

	@PostConstruct
	public void init() {
		freemiumsSelected = new ArrayList<>();
		freemiumSelected = new Freemium();
		try {
			freemiums = freemiumService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean hasFreemiumsSelected() {
		if (freemiumsSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasFreemiumSelected() {
		if (freemiumsSelected.size() == 1) {
			return false;
		}
		return true;
	}
	public void createNew() {
		freemiumSelected = new Freemium();
	}

	public void editFreemiumSelected() {
		freemiumSelected = freemiumsSelected.get(0);
	}
	public void saveFreemium() {
		try {
			if (freemiumSelected.getId() == null) {
				freemiumService.create(freemiumSelected);
				freemiums.add(freemiumSelected);
			} else {
				freemiumService.update(freemiumSelected);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('freemiumDialog').hide()");
		PrimeFaces.current().ajax().update("freemiumDataTable");

	}
	public void deleteFreemium() {
		try {
			this.freemiums.remove(freemiumSelected);
			freemiumService.deleteById(this.freemiumSelected.getId()); // ID's son strings
			this.freemiumSelected = null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "ItemRemoved"));
	}
	public void getAllFreemium() {
		try {
			freemiums = freemiumService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Freemium getFreemiumSelected() {
		return freemiumSelected;
	}

	public void setFreemiumSelected(Freemium freemiumSelected) {
		this.freemiumSelected = freemiumSelected;
	}

	public List<Freemium> getFreemiums() {
		return freemiums;
	}

	public void setFreemiums(List<Freemium> freemiums) {
		this.freemiums = freemiums;
	}

	public List<Freemium> getFreemiumsSelected() {
		return freemiumsSelected;
	}

	public void setFreemiumsSelected(List<Freemium> freemiumsSelected) {
		this.freemiumsSelected = freemiumsSelected;
	}

	public FreemiumService getFreemiumService() {
		return freemiumService;
	}

	public void setFreemiumService(FreemiumService freemiumService) {
		this.freemiumService = freemiumService;
	}
	
	
}
