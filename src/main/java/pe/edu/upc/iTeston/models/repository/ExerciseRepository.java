package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, String>{
	List<Exercise> findByQuestionBank(String id) throws Exception;
}
