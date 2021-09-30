package pe.edu.upc.iTeston.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	@PostConstruct
	public void init() {
		exercisesSelected = new ArrayList<>();
		try {
			exercises = exerciseService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasexercisesSelected() {
		if(exercisesSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
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
