package pe.edu.upc.iTeston.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.TeacherService;
import pe.edu.upc.iTeston.models.entities.Teacher;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.TeacherRepository;

@Named
@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {
	

	@Inject
	private TeacherRepository teacherRepository;
	
	@Override
	public JpaRepository<Teacher, String> getJpaRepository() {
		
		return teacherRepository;
	}
	
	@Override
	public List<Teacher>findByName(String name) throws Exception {
		
		return teacherRepository.findByName(name);
	}

}
