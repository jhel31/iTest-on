package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.Subscription;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.SubscriptionRepository;
@Named
@ApplicationScoped
public class SubscriptionServiceImpl implements SubscriptionService{

	
	@Inject
	private SubscriptionRepository subscriptionRepository;
	@Override
	public JpaRepository <Subscription, Integer> getJpaRepository() {
		return subscriptionRepository;
	}

}
