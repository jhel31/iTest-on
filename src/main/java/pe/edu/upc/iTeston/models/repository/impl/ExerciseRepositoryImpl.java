package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Exercise;
import pe.edu.upc.iTeston.models.repository.ExerciseRepository;

@Named
@ApplicationScoped
public class ExerciseRepositoryImpl implements ExerciseRepository{
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Exercise> findById(String id) throws Exception {
		return findById(id, Exercise.class);
	}

	@Override
	public List<Exercise> findAll() throws Exception {
		String jpql ="SELECT exercise FROM Exercise exercise";
		return findAll(Exercise.class,jpql);
	}
	
	@Override
	public List<Exercise> findByQuestionBank(String id) throws Exception {
		String jpql = "SELECT r FROM Exercise r WHERE r.id_question_bank LIKE '%" + id + "%'" ;	
		System.out.println(jpql);
		return findAll(Exercise.class, jpql);
	}
}
