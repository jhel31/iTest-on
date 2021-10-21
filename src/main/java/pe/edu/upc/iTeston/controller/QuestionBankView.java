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

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.QuizService;
import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.entities.Teacher;

@Named("questionBankView")
@ViewScoped
public class QuestionBankView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<QuestionBank> questionBanks;
	private QuestionBank questionBankSelected;

	private List<QuestionBank> questionBanksSelected;
	private QuestionBank questionBankSearch;
	
	private List<Quiz> quizzes;
	private List<Teacher> teachers;
	
	@Inject
	private QuizService quizService;
	
	@Inject 
	private TeacherService teacherService;
	
	
	@Inject
	private QuestionBankService questionBankService;
	
	@PostConstruct
	public void init() {
		questionBanksSelected = new ArrayList<>();
		questionBanks = new ArrayList<>();
		questionBankSearch = new QuestionBank();
		quizzes = new ArrayList<>();
		teachers = new ArrayList<>();
		try {
			questionBanks = questionBankService.getAll();
			quizzes = quizService.getAll();
			teachers = teacherService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public boolean hasSelectedQuestionBanks() {
        if(questionBanksSelected.isEmpty()) {
        	return false;
        }
        return true;
    }
    
    public boolean hasSelectedQuestionBank() {
        if(questionBanksSelected.size()==1) {
        	return true;
        }
        return false;
    }
    
    public void saveQuestionBank() {
    	try {
    		if(questionBankSelected.getId()==null) {
    			questionBankService.create(questionBankSelected);
    			questionBanks.add(questionBankSelected);    			
    		}
    		else {
    			questionBankService.update(questionBankSelected);
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrimeFaces.current().executeScript("PF('questionBankDialog').hide()");
        PrimeFaces.current().ajax().update("form:questionBankDataTable");
    }
    
    public void createNew() {
        this.questionBankSelected = new QuestionBank();
    }
    
    public void editQuestionBankSelected() {
    	this.questionBankSelected = questionBanksSelected.get(0);
    }
    
    public void deleteQuestionBank() {
		try {
			this.questionBanks.remove(questionBankSelected);
			questionBankService.deleteById(this.questionBankSelected.getId());
			this.questionBankSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
    }
	public void searchQuestionBank() {
		try {
			questionBanks = questionBankService.findByTeacher(questionBankSearch.getTeacher().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllQuestionBank() {
		try {
			questionBanks = questionBankService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public QuestionBank getQuestionBankSearch() {
		return questionBankSearch;
	}
	
	public void setQuestionBankSearch(QuestionBank questionBankSearch) {
		this.questionBankSearch = questionBankSearch;
	}
    
	public List<QuestionBank> getQuestionBanks() {
		return questionBanks;
	}

	public void setQuestionBanks(List<QuestionBank> questionBanks) {
		this.questionBanks = questionBanks;
	}

	public QuestionBank getQuestionBankSelected() {
		return questionBankSelected;
	}

	public void setQuestionBankSelected(QuestionBank questionBankSelected) {
		this.questionBankSelected = questionBankSelected;
	}

	public List<QuestionBank> getQuestionBanksSelected() {
		return questionBanksSelected;
	}

	public void setQuestionBanksSelected(List<QuestionBank> questionBanksSelected) {
		this.questionBanksSelected = questionBanksSelected;
	}

	public QuestionBankService getQuestionBankService() {
		return questionBankService;
	}

	public void setQuestionBankService(QuestionBankService questionBankService) {
		this.questionBankService = questionBankService;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public QuizService getQuizService() {
		return quizService;
	}

	public void setQuizService(QuizService quizService) {
		this.quizService = quizService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	
	
	
}
