package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Course;

public interface CourseRepository extends JpaRepository<Course,String> {
	List<Course> findByName(String name) throws Exception;
}
