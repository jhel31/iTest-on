package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.iTeston.business.crud.CourseService;
import pe.edu.upc.iTeston.models.entities.Course;

@Named("courseView")
@ViewScoped
public class CourseView implements Serializable{


	private static final long serialVersionUID = 1L;
	private List<Course> courses;
	//------------------
	private Course CourseSelected;
	private List<Course> coursesSelected;
	
	@Inject
	private CourseService courseService;
	
	@PostConstruct 
	public void init() {
		coursesSelected = new ArrayList<>();
		try {
			courses=courseService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean hasCoursesSelected() {
		if (coursesSelected.isEmpty() ) {
			return false;
		}
		return true;
	}
	
	public boolean hasCourseSelected() {
		if (coursesSelected.size()==1 ) {
			return true;
		}
		return false;
	}
	
	public void saveCourse() {
		try {
			courseService.create(CourseSelected);
			courses.add(CourseSelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('courseDialog').hide()");
        PrimeFaces.current().ajax().update("courseDataTable");
	}
	
	public void createNew() {
		CourseSelected = new Course();
	
	}
//----
	public List<Course> getCoursesSelected() {
		return coursesSelected;
	}
	public void setCoursesSelected(List<Course> coursesSelected) {
		this.coursesSelected = coursesSelected;
	}
	//--
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	//--
	public Course getCourseSelected() {
		return CourseSelected;
	}

	public void setCourseSelected(Course courseSelected) {
		this.CourseSelected = courseSelected;
	}
	
	
}
