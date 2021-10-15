
package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	private VirtualWallet virtualWalletSearch;
	
	@Inject
	private VirtualWalletService virtualWalletService;
	
	@PostConstruct
	public void init() {
		VirtualWalletsSelected=new ArrayList<>();
		setVirtualWalletSearch(new VirtualWallet());
		getAllVirtualWallet();
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
	public void editVirtualWalletSelected() {
		VirtualWalletSelected = VirtualWalletsSelected.get(0);
	}
	
	public void saveVirtualWalletSelected() {
		try {
			
			if(VirtualWalletSelected.getId() == null) {
				virtualWalletService.create(VirtualWalletSelected);
				virtualWallets.add(VirtualWalletSelected);
			}else{
				virtualWalletService.update(VirtualWalletSelected);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		PrimeFaces.current().executeScript("PF('virtualWalletDialog').hide()");
        PrimeFaces.current().ajax().update("virtualWalletDataTable");
	}
	public void createNew() {
		VirtualWalletSelected = new VirtualWallet();
	}

	public void deleteVirtualWallet() {
		try {
			this.virtualWallets.remove(VirtualWalletSelected);
			virtualWalletService.deleteById(this.VirtualWalletSelected.getId());
			this.VirtualWalletSelected =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Remove","Item Removed"));
		 //PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}
	
	public void searchVirtualWallet(){
		try {
			virtualWallets= virtualWalletService.findBySaldo(virtualWalletSearch.getSaldo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllVirtualWallet(){
		try {
			virtualWallets= virtualWalletService.getAll();
		} catch (Exception e) {
						e.printStackTrace();
		}
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

	public VirtualWallet getVirtualWalletSearch() {
		return virtualWalletSearch;
	}

	public void setVirtualWalletSearch(VirtualWallet virtualWalletSearch) {
		this.virtualWalletSearch = virtualWalletSearch;
	}

	public VirtualWalletService getVirtualWalletService() {
		return virtualWalletService;
	}

	public void setVirtualWallets(List<VirtualWallet> virtualWallets) {
		this.virtualWallets = virtualWallets;
	}

	
	
}
