package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Career;
import pe.edu.upc.iTeston.models.repository.CareerRepository;
@Named
@ApplicationScoped
public class CareerRepositoryImpl implements CareerRepository {

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {

		return entityManager;
	}

	@Override
	public Optional<Career> findById(String id) throws Exception {
		return findById(id, Career.class);
	}

	@Override
	public List<Career> findAll() throws Exception {

		String jpql = "SELECT career FROM Career career ";
		return findAll(Career.class,jpql);
	}

	@Override
	public List<Career> findByName(String name) throws Exception {
		String jpql = "SELECT c FROM Career c WHERE c.name LIKE '%" + name + "%'" ;	
		System.out.println(jpql);
		return findAll(Career.class, jpql);
	}
	
	

}
