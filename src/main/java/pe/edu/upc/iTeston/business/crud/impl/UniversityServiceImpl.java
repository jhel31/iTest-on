package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.University;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.UniversityRepository;

public class UniversityServiceImpl implements UniversityService{

	@Inject
	private UniversityRepository universityRepository; 
	@Override
	public JpaRepository<University, String> getJpaRepository() {
		// TODO Auto-generated method stub
		return universityRepository;
	}

	@Override
	public List<University> nameUniversity(String name) throws Exception {
		// TODO Auto-generated method stub
		return universityRepository.nameUniversity(name);
	}

}
