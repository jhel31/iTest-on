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

import pe.edu.upc.iTeston.business.crud.ApprovalService;
import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.models.entities.Approval;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Student;

@Named("approvalView")
@ViewScoped
public class ApprovalView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Approval approvalSelected;
	private Approval approvalSearch;
	private List<Approval> approvals;
	private List<Approval> approvalsSelected;
	private List<Student> students;
	private List<QuestionBank> questionBanks;


	@Inject
	private ApprovalService approvalService;
	@Inject
	private StudentService studentService;
	@Inject
	private QuestionBankService questionBankService;

	@PostConstruct
	public void init() {
		approvalsSelected = new ArrayList<>();
		approvalSelected = new Approval();
		students = new ArrayList<Student>();
		questionBanks = new ArrayList<QuestionBank>();
		try {
			approvals = approvalService.getAll();
			students = studentService.getAll();
			questionBanks =  questionBankService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNew() {
		approvalSelected = new Approval();
	}

	public void editApprovalSelected() {
		approvalSelected = approvalsSelected.get(0);
	}
	
	
	public void saveApproval() {
		try {
			if (approvalSelected.getId() == null) {
				approvalService.create(approvalSelected);
				approvals.add(approvalSelected);
			} else {
				approvalService.update(approvalSelected);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('approvalDialog').hide()");
		PrimeFaces.current().ajax().update("approvalDataTable");
	}


	public void searchApproval() {
		try {
			approvals = approvalService.findByLevel(approvalSearch.getApprovalLevel());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	public void getAllApproval() {
		try {
			approvals = approvalService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteApproval() {
		try {
			this.approvals.remove(approvalSelected);
			approvalService.deleteById(this.approvalSelected.getId()); // ID's son strings
			this.approvalSelected = null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "ItemRemoved"));	

	}
	public List<Approval> getApproval() {
		return approvals;
	}

	public void setApprovalService(ApprovalService approvalService) {
		this.approvalService = approvalService;
	}

	public Approval getApprovalSelected() {
		return approvalSelected;
	}

	public void setApprovalSelected(Approval approvalSelected) {
		this.approvalSelected = approvalSelected;
	}

	public Approval getApprovalSearch() {
		return approvalSearch;
	}

	public void setApprovalSearch(Approval approvalSearch) {
		this.approvalSearch = approvalSearch;
	}

	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public ApprovalService getApprovalService() {
		return approvalService;
	}


	// Selection
	public boolean hasApprovalsSelected() {
		if (approvalsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasApprovalSelected() {
		if (approvalsSelected.size() == 1) {
			return false;
		}
		return true;
	}

	public List<Approval> getApprovalsSelected() {
		return approvalsSelected;
	}

	public void setApprovalsSelected(List<Approval> approvalsSelected) {
		this.approvalsSelected = approvalsSelected;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public QuestionBankService getQuestionBankService() {
		return questionBankService;
	}

	public void setQuestionBankService(QuestionBankService questionBankService) {
		this.questionBankService = questionBankService;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<QuestionBank> getQuestionBanks() {
		return questionBanks;
	}

	public void setQuestionBanks(List<QuestionBank> questionBanks) {
		this.questionBanks = questionBanks;
	}

	
}
