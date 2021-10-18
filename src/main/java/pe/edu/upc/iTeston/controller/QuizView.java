package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.SubscriptionService;
import pe.edu.upc.iTeston.business.crud.UniversityService;
import pe.edu.upc.iTeston.models.entities.Freemium;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.Subscription;
import pe.edu.upc.iTeston.models.entities.University;

@Named("quizView")
@ViewScoped
public class QuizView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Quiz> quizzes;
	private Quiz quizSelected;
	private List<Quiz> quizzesSelected;

	private List<University> universities;
	private List<Subscription> subscriptions;
	private List<Freemium> freemiums;

	@Inject
	private QuizService quizService;
	@Inject
	private UniversityService uService;
	@Inject
	private SubscriptionService sService;

	@PostConstruct
	public void init() {
		quizzesSelected = new ArrayList<>();
		universities = new ArrayList<University>();
		subscriptions = new ArrayList<Subscription>();
		quizSelected = new Quiz();
		try {
			quizzes = quizService.getAll();
			universities = uService.getAll();
			subscriptions = sService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNew() {
		quizSelected = new Quiz();
	}

	public void editQuizSelected() {
		quizSelected = quizzesSelected.get(0);
	}

	public void saveQuiz() {
		try {
			
			if(quizSelected.getId() == null) {
			quizService.create(quizSelected);
			quizzes.add(quizSelected);
			}
			else {
				quizService.update(quizSelected);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		init();
		PrimeFaces.current().executeScript("PF('quizDialog').hide()");
		PrimeFaces.current().ajax().update("quizDataTable");

	}

	public void deleteQuiz() {
		try {
			this.quizzes.remove(quizSelected);
			quizService.deleteById(this.quizSelected.getId());
			this.quizSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
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

	public List<University> getUniversities() {
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public List<Freemium> getFreemiums() {
		return freemiums;
	}

	public void setFreemiums(List<Freemium> freemiums) {
		this.freemiums = freemiums;
	}

	
	
}
