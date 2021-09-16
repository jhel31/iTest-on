package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.CourseService;
import pe.edu.upc.iTeston.models.entities.Course;
import pe.edu.upc.iTeston.models.repository.CourseRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class CourseServiceImpl implements CourseService {
	@Inject
	private CourseRepository courseRepository;
	
	@Override
	public JpaRepository<Course, String> getJpaRepository() {
		return courseRepository;
	}

}
