package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;
import java.util.Optional;

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
	public List<University> findByName(String name) throws Exception {
		return universityRepository.findByName(name);
	}

	@Override
	public Optional<University> findById(String idUniversity) throws Exception {
		return universityRepository.findById(idUniversity);
	}
	
}
