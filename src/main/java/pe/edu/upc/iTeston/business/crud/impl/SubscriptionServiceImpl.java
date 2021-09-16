package pe.edu.upc.iTeston.business.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.Subscription;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.SubscriptionRepository;

public class SubscriptionServiceImpl implements SubscriptionService{

	
	@Inject
	private SubscriptionRepository subscriptionRepository;
	@Override
	public JpaRepository <Subscription, Integer> getJpaRepository() {
		return subscriptionRepository;
	}

}
