package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.models.entities.Subscription;

public class SubscriptionView implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<Subscription> subscriptions;
	private Subscription subscriptionSelected;
	private List<Subscription> subscriptionsSelected;
	private Subscription subscriptionSearch;
	
	
	@Inject
	private SubscriptionService subscriptionService;
	@PostConstruct
	public void init() {
		subscriptionsSelected = new ArrayList<>();
		subscriptionSearch = new Subscription();
		getAllSubscription();
	}
	private void getAllSubscription() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
