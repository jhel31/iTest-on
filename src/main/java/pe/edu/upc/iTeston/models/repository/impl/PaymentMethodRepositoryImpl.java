package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import pe.edu.upc.iTeston.models.entities.PaymentMethod;
import pe.edu.upc.iTeston.models.repository.PaymentMethodRepository;

public class PaymentMethodRepositoryImpl implements PaymentMethodRepository{

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;}

	@Override
	public Optional<PaymentMethod> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentMethod> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
