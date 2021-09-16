package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;
@Named
@ApplicationScoped
public class TeacherRepositoryImpl implements TeacherRepository {
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
	
		return entityManager;
	}

	@Override
	public Optional<Teacher> findById(String id) throws Exception {
		
		return findById(id, Teacher.class);
	}

	@Override
	public List<Teacher> findAll() throws Exception {
		String jpql = "SELECT teacher FROM Teacher teacher ";
		return findAll(Teacher.class,jpql);
	}

}
