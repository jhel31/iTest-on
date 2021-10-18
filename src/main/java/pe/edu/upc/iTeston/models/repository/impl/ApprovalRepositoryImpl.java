package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.repository.ApprovalRepository;

@Named
@ApplicationScoped
public class ApprovalRepositoryImpl implements ApprovalRepository {

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<Approval> findById(String id) throws Exception {
		return findById(id, Approval.class);
	}

	@Override
	public List<Approval> findAll() throws Exception {
		String jpql = "SELECT approval FROM Approvals approval";
		return findAll(Approval.class, jpql);
	}

	@Override
	public List<Approval> findByLevel(Integer level) throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT a FROM Approvals a WHERE a.level_approval LIKE '%" + level + "%'" ;
		System.out.println(jpql);
		return findAll(Approval.class, jpql); 
	}

}
