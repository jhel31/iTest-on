package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.repository.CareerRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

public class CareerServiceImpl implements CareerService {

	@Inject
	private CareerRepository careerRepository;
	
	@Override
	public JpaRepository<Career, String> getJpaRepository() {
		return careerRepository;
	}

	@Override
	public List<Career> name_career(String name) throws Exception {
		// TODO Auto-generated method stub
		return careerRepository.name_career(name);
	}

}
