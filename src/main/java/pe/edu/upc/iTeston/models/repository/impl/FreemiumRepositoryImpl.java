package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Freemium;
import pe.edu.upc.iTeston.models.repository.FreemiumRepository;

@Named
@ApplicationScoped
public class FreemiumRepositoryImpl implements FreemiumRepository {

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Freemium> findById(String id) throws Exception {
		return findById(id, Freemium.class);
	}

	@Override
	public List<Freemium> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT freemium FROM Freemiums freemium";
		return findAll(Freemium.class, jpql);
	}

}
