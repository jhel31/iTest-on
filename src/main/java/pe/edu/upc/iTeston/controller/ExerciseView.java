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

import pe.edu.upc.iTeston.business.crud.ExerciseService;
import pe.edu.upc.iTeston.models.entities.Exercise;
@Named("exerciseView")
@ViewScoped
public class ExerciseView implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<Exercise> exercises;
	private Exercise exerciseSelected;
	private List<Exercise> exercisesSelected;
	@Inject
	private ExerciseService exerciseService;
	private Exercise exerciseSearch;
	

	@PostConstruct
	public void init() {
		exercisesSelected = new ArrayList<>();
		exercises = new ArrayList<>();
		exerciseSearch = new Exercise();
		try {
			exercises = exerciseService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public boolean hasSelectedExercises() {
        if(exercisesSelected.isEmpty()) {
        	return false;
        }
        return true;
    }

    public boolean hasSelectedExercise() {
        if(exercisesSelected.size()==1) {
        	return true;
        }
        return false;
    }
    
	public void createNew() {
		exerciseSelected = new Exercise();		
	}
	public void editExerciseSelected() {
		exerciseSelected = exercisesSelected.get(0);
	}
	
	public void saveExercise() {
		try {
    		if(exerciseSelected.getId()==null) {
    			exerciseService.create(exerciseSelected);
    			exercises.add(exerciseSelected);    			
    		}
    		else {
    			exerciseService.update(exerciseSelected);
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('exerciseDialog').hide()");
		PrimeFaces.current().ajax().update("form:exerciseDataTable");
	
	}

    public void deleteExercise() {
		try {
			this.exercises.remove(exerciseSelected);
			exerciseService.deleteById(this.exerciseSelected.getId());
			this.exerciseSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
    }

	public void searchExercise() {
		try {
			exercises = exerciseService.findByQuestionBank(exerciseSearch.getQuestionBank().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
    
	public void getAllExercise() {
		try {
			exercises = exerciseService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	public Exercise getExerciseSearch() {
		return exerciseSearch;
	}
	
	public void setExerciseSearch(Exercise exerciseSearch) {
		this.exerciseSearch = exerciseSearch;
	}

	public Exercise getExerciseSelected() {
		return exerciseSelected;
	}

	public void setExerciseSelected(Exercise exerciseSelected) {
		this.exerciseSelected = exerciseSelected;
	}

	public List<Exercise> getExercisesSelected() {
		return exercisesSelected;
	}

	public void setExercisesSelected(List<Exercise> exercisesSelected) {
		this.exercisesSelected = exercisesSelected;
	}

	public ExerciseService getExerciseService() {
		return exerciseService;
	}

	public void setExerciseService(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}


}