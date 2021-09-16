package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.repository.ApprovalRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class ApprovalServiceImpl implements ApprovalService {

	@Inject
	private ApprovalRepository approvalRepository;
	
	@Override
	public JpaRepository<Approval, String> getJpaRepository() {
		
		return approvalRepository;
	}

}
