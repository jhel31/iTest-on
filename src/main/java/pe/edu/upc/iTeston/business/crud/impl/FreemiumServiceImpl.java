package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.FreemiumService;
import pe.edu.upc.iTeston.models.entities.Freemium;
import pe.edu.upc.iTeston.models.repository.FreemiumRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class FreemiumServiceImpl implements FreemiumService {

	@Inject
	private FreemiumRepository freemiumRepository;
	@Override
	public JpaRepository<Freemium, String> getJpaRepository() {
		
		return freemiumRepository;
	}

}
