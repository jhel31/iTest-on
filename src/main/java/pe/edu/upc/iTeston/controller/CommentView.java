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

import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.business.crud.QuestionBankService;
import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.entities.QuestionBank;
import pe.edu.upc.iTeston.models.entities.Student;

@Named("commentView")
@ViewScoped
public class CommentView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Comment commentSelected;
	private Comment commentSearch;
	private List<Comment> comments;
	private List<Comment> commentsSelected;
	
	private List<Student> students;
	private List<QuestionBank> questionBanks;
	
	@Inject
	private CommentService commentService;

	@Inject 
	private StudentService studentService;
	
	@Inject
	private QuestionBankService questionBankService;
	
	
	@PostConstruct
	public void init() {
		commentsSelected = new ArrayList<>();
		commentSelected = new Comment();
		students = new ArrayList<Student>();
		questionBanks = new ArrayList<QuestionBank>();
		try {
			comments = commentService.getAll();
			students = studentService.getAll();
			questionBanks =  questionBankService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Selection
	public boolean hasCommentsSelected() {
		if (commentsSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasCommentSelected() {
		if (commentsSelected.size() == 1) {
			return false;
		}
		return true;
	}
	
	//Creation
	public void createNew() {
		commentSelected = new Comment();
	}
	
	//Edition
	public void editCommentSelected() {
		commentSelected = commentsSelected.get(0);
	}
	
	//save changes
	public void saveComment() {
		try {
			if (commentSelected.getId() == null) {
				commentService.create(commentSelected);
				comments.add(commentSelected);
			}
			else {
				commentService.update(commentSelected);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('commentDialog').hide()");
		PrimeFaces.current().ajax().update("commentDataTable");
	}
	
	//Deletion
	public void deleteComment() {
		try {
			this.comments.remove(commentSelected);
			commentService.deleteById(this.commentSelected.getId()); // ID's son strings
			this.commentSelected = null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "ItemRemoved"));
	}
	
	//Searching
	
	public void searchComment() {
		try {
			comments = commentService.findByDescription(commentSearch.getDescription());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//call
	
	public void getAllComment() {
		try {
			comments = commentService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<Comment> getComments() {
		return comments;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public Comment getCommentSelected() {
		return commentSelected;
	}

	public void setCommentSelected(Comment commentSelected) {
		this.commentSelected = commentSelected;
	}

	public List<Comment> getCommentsSelected() {
		return commentsSelected;
	}

	public void setCommentsSelected(List<Comment> commentsSelected) {
		this.commentsSelected = commentsSelected;
	}

	public Comment getCommentSearch() {
		return commentSearch;
	}

	public void setCommentSearch(Comment commentSearch) {
		this.commentSearch = commentSearch;
	}

	public CommentService getCommentService() {
		return commentService;
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

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
