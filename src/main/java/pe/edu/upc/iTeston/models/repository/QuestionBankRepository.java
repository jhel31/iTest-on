package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.QuestionBank;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, String>{
	List<QuestionBank> findByTeacher(String id) throws Exception;
}
