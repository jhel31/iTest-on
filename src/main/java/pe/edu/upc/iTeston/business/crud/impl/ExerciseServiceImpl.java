package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.models.entities.Exercise;
import pe.edu.upc.iTeston.models.repository.ExerciseRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class ExerciseServiceImpl implements ExerciseService{

	@Inject
	private ExerciseRepository exerciseRepository;
	
	@Override
	public JpaRepository<Exercise, String> getJpaRepository() {
		return exerciseRepository;
	}

	@Override
	public List<Exercise> findByQuestionBank(String id) throws Exception {
		return exerciseRepository.findByQuestionBank(id);
	}
}
