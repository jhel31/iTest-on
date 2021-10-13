package pe.edu.upc.iTeston.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private Freemium freemiumSearch;
	
	@Inject
	private FreemiumService freemiumService;
	
	@PostConstruct
	public void init() {
		freemiumsSelected = new ArrayList<>();
		try {
			freemiums = freemiumService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void createNew() {
		freemiumSelected = new Freemium();
	}
	
	public void saveFreemium() {
		try {
			if (freemiumSelected.getId() == null) {
				freemiumService.create(freemiumSelected);
				freemiums.add(freemiumSelected);
			}
			else {
				freemiumService.update(freemiumSelected);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('freemiumDialog').hide()");
		PrimeFaces.current().ajax().update("freemiumDataTable");
	
	}

}
