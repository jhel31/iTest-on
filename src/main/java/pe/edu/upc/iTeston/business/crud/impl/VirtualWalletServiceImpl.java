package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.VirtualWalletRepository;
@Named
@ApplicationScoped
public class VirtualWalletServiceImpl implements VirtualWalletService {

	@Inject
	private VirtualWalletRepository virtualWalletRepository;
	@Override
	public JpaRepository<VirtualWallet, String> getJpaRepository() {
		
		return virtualWalletRepository;
	}
	
	@Override
	public List<VirtualWallet>findBySaldo(Float saldo) throws Exception {
		
		return virtualWalletRepository.findBySaldo(saldo);
	}


}
