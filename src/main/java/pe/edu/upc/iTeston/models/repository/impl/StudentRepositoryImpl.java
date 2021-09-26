package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.repository.StudentRepository;
@Named
@ApplicationScoped
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Student> findById(String id) throws Exception {
		return findById(id, Student.class);
	}

	@Override
	public List<Student> findAll() throws Exception {
		String jpql ="SELECT student FROM Student student";
		return findAll(Student.class,jpql);
	}

	

}
