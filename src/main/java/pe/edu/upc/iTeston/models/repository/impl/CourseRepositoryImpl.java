package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Course;
import pe.edu.upc.iTeston.models.repository.CourseRepository;

@Named
@ApplicationScoped
public class CourseRepositoryImpl implements CourseRepository {
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
	
		return entityManager;
	}

	@Override
	public Optional<Course> findById(String id) throws Exception {

		return findById(id, Course.class);
	}

	@Override
	public List<Course> findAll() throws Exception {
		String jpql = "SELECT course FROM Course course ";
		return findAll(Course.class,jpql);
	}

}
