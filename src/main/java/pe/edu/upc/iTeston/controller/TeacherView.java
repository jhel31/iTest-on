package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.Teacher;

@Named("teacherView")
@ViewScoped
public class TeacherView implements Serializable {


	private static final long serialVersionUID = 1L;
	
private List<Teacher>teachers;
	
	@Inject
	private TeacherService teacherService;
	
	@PostConstruct
	public void init()
	{
		try {
			teachers=teacherService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
}
