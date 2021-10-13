package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.models.entities.Approval;

@Named("approvalView")
@ViewScoped
public class ApprovalView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Approval approvalSelected;
	private Approval approvalSearch;
	private List<Approval> approvals;
	
	@Inject
	private ApprovalService approvalService;
	
	@PostConstruct
	public void init() {
		try {
			approvals = approvalService.getAll();
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createNew() {
		approvalSelected = new Approval();
	}
	
	public void saveApproval() {
		try {
			if (approvalSelected.getId() == null) {
				approvalService.create(approvalSelected);
				approvals.add(approvalSelected);
			}
			else {
				approvalService.update(approvalSelected);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('approvalDialog').hide()");
		PrimeFaces.current().ajax().update("approvalDataTable");
	}
	
	public void getAllApproval() {
		try {
			approvals = approvalService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<Approval> getApproval(){
		return approvals;
	}
	
	public void setApprovalService (ApprovalService approvalService) {
		this.approvalService = approvalService;
	}

	public Approval getApprovalSelected() {
		return approvalSelected;
	}

	public void setApprovalSelected(Approval approvalSelected) {
		this.approvalSelected = approvalSelected;
	}

	public Approval getApprovalSearch() {
		return approvalSearch;
	}

	public void setApprovalSearch(Approval approvalSearch) {
		this.approvalSearch = approvalSearch;
	}
	
}
