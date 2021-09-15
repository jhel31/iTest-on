package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Career;

public interface CareerRepository extends JpaRepository<Career, String> {
	List<Career> name_career(String name) throws Exception;
}
