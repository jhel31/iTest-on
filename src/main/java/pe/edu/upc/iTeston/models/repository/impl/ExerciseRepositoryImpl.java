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
	
	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<Exercise> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return findById(id, Exercise.class);
	}

	@Override
	public List<Exercise> findAll() throws Exception {
		String jpql ="SELECT exercise FROM Exercise Exercise";
		return findAll(Exercise.class,jpql);
	}

}
