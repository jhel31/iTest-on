package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Universities")
public class University {

	@Id
	@Column(name = "id_university", length = 10, nullable = false)
	private String id;

	@Column(name = "name_university", length = 10, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<UniversityDetail> universityDetail;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Quiz> quizzes;
	
	
}
