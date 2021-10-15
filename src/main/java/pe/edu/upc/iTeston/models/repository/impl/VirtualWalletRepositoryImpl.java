package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import pe.edu.upc.iTeston.models.entities.VirtualWallet;
import pe.edu.upc.iTeston.models.repository.VirtualWalletRepository;
@Named
@ApplicationScoped
public class VirtualWalletRepositoryImpl implements VirtualWalletRepository {
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		
		return entityManager;
	}

	@Override
	public Optional<VirtualWallet> findById(String id) throws Exception {
		
		return findById(id, VirtualWallet.class);
	}

	@Override
	public List<VirtualWallet> findAll() throws Exception {
		String jpql = "SELECT virtualWallet FROM VirtualWallet virtualWallet ";
		return findAll(VirtualWallet.class,jpql);
	}
	
	@Override
	public List<VirtualWallet> findBySaldo(Float saldo) throws Exception{
		String jpql ="SELECT r FROM VirtualWallet r WHERE r.saldo LIKE '%" + saldo +"%'";
		System.out.print(jpql);
		return findAll(VirtualWallet.class,jpql);
	}
	
}
