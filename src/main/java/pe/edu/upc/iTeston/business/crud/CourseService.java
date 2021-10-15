package pe.edu.upc.iTeston.business.crud;

import java.util.List;


import pe.edu.upc.iTeston.models.entities.Course;

public interface CourseService extends CrudService<Course,String> {
	List<Course> findByName(String name) throws Exception;
}
