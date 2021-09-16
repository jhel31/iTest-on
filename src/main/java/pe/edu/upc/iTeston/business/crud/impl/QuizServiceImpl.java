package pe.edu.upc.iTeston.business.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.QuizRepository;

public class QuizServiceImpl implements QuizService{
 
	@Inject
	private QuizRepository quizRepository;
	
	@Override
	public JpaRepository<Quiz, String> getJpaRepository() {
		return quizRepository;
	}
	

}
