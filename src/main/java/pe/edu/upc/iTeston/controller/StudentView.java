package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.models.entities.Student;



@Named("studentView")//// region view
@ViewScoped ////constructor
public class StudentView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Student selectedStudent;
	private List<Student> students;
	
	private List<Student> studentSelected;

	@Inject
	private StudentService studentService;
	
	@PostConstruct
	public void init() {
		try{
			students= studentService.getAll();
	}catch(Exception e)
		{e.printStackTrace();
	
		}
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudents() {
		return students;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<Student> getStudentSelected() {
		return studentSelected;
	}

	public void setStudentSelected(List<Student> studentSelected) {
		this.studentSelected = studentSelected;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
