package pe.edu.upc.iTeston.models.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public List<Career> name_career(String name) throws Exception {
		return findByField("name_career", name);
	}
	
	public List<Career> findByField(String field, String value) throws Exception {

		List<Career> careers = new ArrayList<Career>();
		String jpql = "SELECT ca FROM Career ca WHERE ca." + field + "=" + value + "'";
		TypedQuery<Career> typedQuery = getEntityManager().createQuery(jpql, Career.class);
		careers =  typedQuery.getResultList();
		return careers;
	}

}
