package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.QuestionBank;

public interface QuestionBankService extends CrudService<QuestionBank, String>{
	List<QuestionBank> findByTeacher(String id) throws Exception;
}
