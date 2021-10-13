package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.CareerService;
import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.repository.CareerRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
@Named
@ApplicationScoped
public class CareerServiceImpl implements CareerService {

	@Inject
	private CareerRepository careerRepository;
	
	@Override
	public JpaRepository<Career, String> getJpaRepository() {
		return careerRepository;
	}

	@Override
	public List<Career> findByName(String name) throws Exception {
		return careerRepository.findByName(name);
	}

}
