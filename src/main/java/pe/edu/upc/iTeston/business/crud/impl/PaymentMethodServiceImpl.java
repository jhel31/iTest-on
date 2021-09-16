package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.PaymentMethodService;
import pe.edu.upc.iTeston.models.entities.PaymentMethod;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.PaymentMethodRepository;
@Named
@ApplicationScoped
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Inject
	private PaymentMethodRepository paymentMethodRepository;
	
	@Override
	public JpaRepository<PaymentMethod, String> getJpaRepository() {
		return paymentMethodRepository ;
	}

}
