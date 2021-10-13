package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.models.entities.QuestionBank;

@Named("questionBankView")
@ViewScoped
public class QuestionBankView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<QuestionBank> questionBanks;
	private QuestionBank questionBankSelected;
	private List<QuestionBank> questionBanksSelected;
	
	@Inject
	private QuestionBankService questionBankService;
	
	@PostConstruct
	public void init() {
		questionBanksSelected = new ArrayList<>();
		try {
			questionBanks = questionBankService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	
	
	
}
