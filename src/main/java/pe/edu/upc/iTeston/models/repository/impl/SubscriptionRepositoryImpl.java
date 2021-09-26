package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Subscription;
import pe.edu.upc.iTeston.models.repository.SubscriptionRepository;
@Named
@ApplicationScoped
public class SubscriptionRepositoryImpl implements SubscriptionRepository{

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		
		return entityManager;
	}

	@Override
	public Optional<Subscription> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return findById(id, Subscription.class);
	}

	@Override
	public List<Subscription> findAll() throws Exception {
		String jpql ="SELECT subscription FROM Subscription subscription";
		return findAll(Subscription.class,jpql);
	}

}
