package pe.edu.upc.iTeston.models.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public List<University> nameUniversity(String name) throws Exception {
		// TODO Auto-generated method stub
		return findByField("name_university",name);
	}
	public List<University> findByField(String field, String value) throws Exception {

		List<University> Universities = new ArrayList<University>();
		String jpql = "SELECT uni FROM University uni WHERE uni." + field + "=" + value + "'";
		TypedQuery<University> typedQuery = getEntityManager().createQuery(jpql, University.class);
		Universities =  typedQuery.getResultList();
		return Universities;
	}
}
