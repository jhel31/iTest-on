package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.CourseService;
import pe.edu.upc.iTeston.models.entities.Course;

@Named("courseView")
@ViewScoped
public class CourseView implements Serializable{


	private static final long serialVersionUID = 1L;
	private List<Course> courses;
	
	@Inject
	private CourseService courseService;
	
	@PostConstruct 
	public void init() {
		try {
			courses=courseService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
}
