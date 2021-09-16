package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")

public class Course{

		@Id
		@Column(name = "id_course", length = 10, nullable = false)
		private String id;
		
		@Column(name = "name_course",length= 15, nullable = false)	
		private String name;
		
		@OneToMany(mappedBy="course", fetch=FetchType.LAZY)
		private List<Teacher> teachers;
}
