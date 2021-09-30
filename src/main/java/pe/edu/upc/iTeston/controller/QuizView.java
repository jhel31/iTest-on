package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.models.entities.Quiz;

@Named("quizView")
@ViewScoped
public class QuizView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Quiz> quizzes;
	private Quiz quizSelected;
	private List<Quiz> quizzesSelected;

	@Inject
	private QuizService quizService;

	@PostConstruct
	public void init() {
		quizzesSelected = new ArrayList<>();
		try {
			quizzes = quizService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get and sets
	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Quiz getQuizSelected() {
		return quizSelected;
	}

	public void setQuizSelected(Quiz quizSelected) {
		this.quizSelected = quizSelected;
	}

	public List<Quiz> getQuizzesSelected() {
		return quizzesSelected;
	}

	public void setQuizzesSelected(List<Quiz> quizzesSelected) {
		this.quizzesSelected = quizzesSelected;
	}

	public QuizService getQuizService() {
		return quizService;
	}

	public void setQuizService(QuizService quizService) {
		this.quizService = quizService;
	}

}
