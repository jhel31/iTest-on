package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

	import pe.edu.upc.iTeston.models.entities.PaymentMethod;
import pe.edu.upc.iTeston.models.repository.PaymentMethodRepository;
@Named
@ApplicationScoped
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository{

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		
		return entityManager;
	}
	@Override
	public Optional<PaymentMethod> findById(String id) throws Exception {
		
		return findById(id, PaymentMethod.class);
	}

	@Override
	public List<PaymentMethod> findAll() throws Exception {
		String jpql = "SELECT paymentMethod FROM PaymentMethod paymentMethod";
		return findAll(PaymentMethod.class, jpql);
	}

}
