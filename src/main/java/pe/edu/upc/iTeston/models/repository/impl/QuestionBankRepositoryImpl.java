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

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<QuestionBank> findById(String id) throws Exception {
		return findById(id, QuestionBank.class);
	}

	@Override
	public List<QuestionBank> findAll() throws Exception {
		String jpql = "SELECT questionbank FROM QuestionBank questionbank";
		return findAll(QuestionBank.class,jpql);
	}

	@Override
	public List<QuestionBank> findByTeacher(String id) throws Exception {
		String jpql = "SELECT r FROM QuestionBank r WHERE r.teacher.id LIKE '%" + id + "%'" ;	
		System.out.println(jpql);
		return findAll(QuestionBank.class, jpql);
	}
}
