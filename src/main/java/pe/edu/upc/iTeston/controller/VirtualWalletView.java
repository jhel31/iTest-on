package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.VirtualWalletService;
import pe.edu.upc.iTeston.models.entities.VirtualWallet;

@Named("virtualWalletView")
@ViewScoped
public class VirtualWalletView implements Serializable{


	private static final long serialVersionUID = 1L;
	private List<VirtualWallet>virtualWallets;
	
	private VirtualWallet  VirtualWalletSelected;
	private List<VirtualWallet> VirtualWalletsSelected;
	@Inject
	private VirtualWalletService virtualWalletService;
	
	@PostConstruct
	public void init() {
		VirtualWalletsSelected=new ArrayList<>();
		try {
			virtualWallets=virtualWalletService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean hasVirtualWalletsSelected() {
		if (VirtualWalletsSelected.isEmpty() ) {
			return false;
		}
		return true;
	}
	
	public boolean hasVirtualWalletSelected() {
		if (VirtualWalletsSelected.size()==1 ) {
			return true;
		}
		return false;
	}
	
	public void saveVirtualWalletSelected() {
		try {
			virtualWalletService.create(VirtualWalletSelected);
			virtualWallets.add(VirtualWalletSelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('courseDialog').hide()");
        PrimeFaces.current().ajax().update("courseDataTable");
	}
	public void createNew() {
		VirtualWalletSelected = new VirtualWallet();
	}

	public List<VirtualWallet> getVirtualWallets() {
		return virtualWallets;
	}

	public void setVirtualWalletService(VirtualWalletService virtualWalletService) {
		this.virtualWalletService = virtualWalletService;
	}

	public VirtualWallet getVirtualWalletSelected() {
		return VirtualWalletSelected;
	}

	public void setVirtualWalletSelected(VirtualWallet virtualWalletSelected) {
		VirtualWalletSelected = virtualWalletSelected;
	}

	public List<VirtualWallet> getVirtualWalletsSelected() {
		return VirtualWalletsSelected;
	}

	public void setVirtualWalletsSelected(List<VirtualWallet> virtualWalletsSelected) {
		VirtualWalletsSelected = virtualWalletsSelected;
	}

	
	
}
