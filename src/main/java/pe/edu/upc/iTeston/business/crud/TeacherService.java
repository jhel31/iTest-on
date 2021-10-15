package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Teacher;

public interface TeacherService extends CrudService<Teacher, String> {
	List<Teacher> findByName(String name) throws Exception;
}
