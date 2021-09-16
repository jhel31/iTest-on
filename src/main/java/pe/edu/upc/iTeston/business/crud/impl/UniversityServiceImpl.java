package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.UniversityRepository;
@Named
@ApplicationScoped
public class UniversityServiceImpl implements UniversityService{

	@Inject
	private UniversityRepository universityRepository; 
	@Override
	public JpaRepository<University, String> getJpaRepository() {
		return universityRepository;
	}

	@Override
	public List<University> nameUniversity(String name) throws Exception {
		return universityRepository.nameUniversity(name);
	}

}
