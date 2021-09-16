package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.repository.QuestionBankRepository;

@Named
@ApplicationScoped
public class QuestionBankRepositoryImpl implements QuestionBankRepository{

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<QuestionBank> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return findById(id, QuestionBank.class);
	}

	@Override
	public List<QuestionBank> findAll() throws Exception {
		String jpql = "SELECT questionbank FROM QuestionBank questionbank";
		return findAll(QuestionBank.class,jpql);
	}

}
