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


import pe.edu.upc.iTeston.business.crud.CourseService;
import pe.edu.upc.iTeston.models.entities.Course;

@Named("courseView")
@ViewScoped
public class CourseView implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private List<Course> courses;
	//------------------
	private Course courseSelected;
	private List<Course> coursesSelected;
	private Course courseSearch;
	

	@Inject
	private CourseService courseService;
	
	@PostConstruct 
	public void init() {
		coursesSelected = new ArrayList<>();
		setCourseSearch(new Course());
		getAllCourse();
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
	
	public void editCourseSelected() {
		courseSelected = coursesSelected.get(0);
	}
	
	public void saveCourse() {
		try {
			
			
			if(courseSelected.getId() == null) {
				courseService.create(courseSelected);
				courses.add(courseSelected);
			}else{
				courseService.update(courseSelected);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		PrimeFaces.current().executeScript("PF('courseDialog').hide()");
        PrimeFaces.current().ajax().update("courseDataTable");
	}
	
	public void createNew() {
		courseSelected = new Course();
	
	}
	
	public void deleteCourse() {
		try {
			this.courses.remove(courseSelected);
			courseService.deleteById(this.courseSelected.getId());
			this.courseSelected =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Remove","Item Removed"));
		 //PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}
	
	public void searchCourse(){
		try {
			courses= courseService.findByName(courseSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllCourse(){
		try {
			courses= courseService.getAll();
		} catch (Exception e) {
						e.printStackTrace();
		}
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
		return courseSelected;
	}

	public void setCourseSelected(Course courseSelected) {
		this.courseSelected = courseSelected;
	}
	
	public void setCourseSearch(Course courseSearch) {
		this.courseSearch = courseSearch;
	}
	public Course getCourseSearch() {
		return courseSearch;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
