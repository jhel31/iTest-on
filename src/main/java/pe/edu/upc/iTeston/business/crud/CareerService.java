package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Career;

public interface CareerService extends CrudService<Career, String> {
	
	List<Career> name_career(String name) throws Exception;
}
