package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.UniversityDetailService;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.UniversityDetailRepository;
@Named
@ApplicationScoped
public class UniversityDetailServiceImpl implements UniversityDetailService{

	@Inject
	private UniversityDetailRepository universityDetailRepository;
	
	@Override
	public JpaRepository<UniversityDetail, String> getJpaRepository() {
		return universityDetailRepository;
	}

}
