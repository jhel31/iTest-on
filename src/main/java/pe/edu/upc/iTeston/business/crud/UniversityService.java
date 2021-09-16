package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.University;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;

public interface UniversityService extends CrudService<UniversityDetail, String> {
	
	List<University>nameUniversity(String name)throws Exception;
}
