package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.University;
import pe.edu.upc.iTeston.models.repository.UniversityRepository;
@Named
@ApplicationScoped
public class UniversityRepositoryImpl implements UniversityRepository{
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<University> findById(String id) throws Exception {
		return findById(id,University.class);
	}

	@Override
	public List<University> findAll() throws Exception {
		String jpql = "SELECT university FROM University university ";

		return findAll(University.class,jpql);
	}

	@Override
	public List<University> findByName(String name) throws Exception {
		String jpql = "SELECT u FROM University u WHERE u.name LIKE '%" + name + "%'" ;	
		System.out.println(jpql);
		return findAll(University.class, jpql);
	}
	
}
