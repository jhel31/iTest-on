package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.University;

public interface UniversityService extends CrudService<University, String> {
	
	List<University>findByName(String name)throws Exception;
}
