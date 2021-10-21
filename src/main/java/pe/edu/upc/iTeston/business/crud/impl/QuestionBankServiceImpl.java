package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.QuestionBankRepository;

@Named
@ApplicationScoped
public class QuestionBankServiceImpl implements QuestionBankService{

	@Inject
	private QuestionBankRepository questionBankRepository;
	
	@Override
	public JpaRepository<QuestionBank, String> getJpaRepository() {
		// TODO Auto-generated method stub
		return questionBankRepository;
	}

	@Override
	public List<QuestionBank> findByTeacher(String id) throws Exception {
		return questionBankRepository.findByTeacher(id);
	}
}
