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

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.Teacher;


@Named("teacherView")
@ViewScoped
public class TeacherView implements Serializable {


	private static final long serialVersionUID = 1L;
	
private List<Teacher>teachers;
private Teacher TeacherSelected;
private List<Teacher>TeachersSelected;
private Teacher TeacherSearch;
	
	@Inject
	private TeacherService teacherService;
	
	@PostConstruct
	public void init()
	{
		TeachersSelected= new ArrayList<>();
		setTeacherSearch(new Teacher());
		getAllTeacher();
		
	}

	public boolean hasTeachersSelected() {
		if (TeachersSelected.isEmpty() ) {
			return false;
		}
		return true;
	}
	
	public boolean hasTeacherSelected() {
		if (TeachersSelected.size()==1 ) {
			return true;
		}
		return false;
	}
	public void editTeacherSelected() {
		TeacherSelected = TeachersSelected.get(0);
	}
	
	public void saveTeacherSelected() {
		try {
			
			if(TeacherSelected.getId() == null) {
				teacherService.create(TeacherSelected);
				teachers.add(TeacherSelected);
			}else{
				teacherService.update(TeacherSelected);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		PrimeFaces.current().executeScript("PF('teacherDialog').hide()");
        PrimeFaces.current().ajax().update("teacherDataTable");
	}
	public void createNew() {
		TeacherSelected = new Teacher();
	}

	public void deleteTeacher() {
		try {
			this.teachers.remove(TeacherSelected);
			teacherService.deleteById(this.TeacherSelected.getId());
			this.TeacherSelected =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Remove","Item Removed"));
		 //PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}
	
	public void searchTeacher(){
		try {
			teachers= teacherService.findByName(TeacherSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getAllTeacher(){
		try {
			teachers= teacherService.getAll();
		} catch (Exception e) {
						e.printStackTrace();
		}
	}
	
	
	
	
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public Teacher getTeacherSelected() {
		return TeacherSelected;
	}

	public void setTeacherSelected(Teacher teacherSelected) {
		TeacherSelected = teacherSelected;
	}

	public List<Teacher> getTeachersSelected() {
		return TeachersSelected;
	}

	public void setTeachersSelected(List<Teacher> teachersSelected) {
		TeachersSelected = teachersSelected;
	}

	public Teacher getTeacherSearch() {
		return TeacherSearch;
	}

	public void setTeacherSearch(Teacher teacherSearch) {
		TeacherSearch = teacherSearch;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
