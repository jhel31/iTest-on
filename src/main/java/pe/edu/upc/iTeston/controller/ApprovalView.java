package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.models.entities.Approval;

public class ApprovalView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Approval selectedApproval;
	

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
	
	public List<Approval> getApproval(){
		return approvals;
	}
	
	public void setApprovalService (ApprovalService approvalService) {
		this.approvalService = approvalService;
	}
	
	public Approval getSelectedApproval() {
		return selectedApproval;
	}

	public void setSelectedApproval(Approval selectedApproval) {
		this.selectedApproval = selectedApproval;
	}
}
