package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
	List<Teacher> findByName(String name) throws Exception;
}
