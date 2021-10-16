package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Approval;


public interface ApprovalRepository extends JpaRepository<Approval, String> {
	List<Approval> findByLevel(Integer level) throws Exception;
	
}
