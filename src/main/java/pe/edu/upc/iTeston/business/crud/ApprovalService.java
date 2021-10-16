package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Approval;

public interface ApprovalService extends CrudService<Approval, String> {
	List<Approval> findByLevel(Integer level) throws Exception;
}
