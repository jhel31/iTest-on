package pe.edu.upc.iTeston.business.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.iTeston.business.crud.StudentService;
import pe.edu.upc.iTeston.models.entities.Student;
import pe.edu.upc.iTeston.models.repository.JpaRepository;
import pe.edu.upc.iTeston.models.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

	
	@Inject
	private StudentRepository studentRepository;
	@Override
	public JpaRepository<Student, String> getJpaRepository() {
		return studentRepository;
	}

}
