package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;

@Named("virtualWalletView")
@ViewScoped
public class VirtualWalletView implements Serializable{


	private static final long serialVersionUID = 1L;
	private List<VirtualWallet>virtualWallets;
	
	@Inject
	private VirtualWalletService virtualWalletService;
	
	@PostConstruct
	public void init() {
		try {
			virtualWallets=virtualWalletService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<VirtualWallet> getVirtualWallets() {
		return virtualWallets;
	}

	public void setVirtualWalletService(VirtualWalletService virtualWalletService) {
		this.virtualWalletService = virtualWalletService;
	}

	
	
}
