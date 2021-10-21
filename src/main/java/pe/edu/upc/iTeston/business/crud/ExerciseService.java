package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Exercise;

public interface ExerciseService extends CrudService<Exercise, String>{
	List<Exercise> findByQuestionBank(String id) throws Exception;
}
