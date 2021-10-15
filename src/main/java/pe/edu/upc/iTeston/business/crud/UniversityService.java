package pe.edu.upc.iTeston.business.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.iTeston.models.entities.University;

public interface UniversityService extends CrudService<University, String> {
	
	List<University>findByName(String name)throws Exception;
	Optional<University> findById(String idUniversity) throws Exception;
}
