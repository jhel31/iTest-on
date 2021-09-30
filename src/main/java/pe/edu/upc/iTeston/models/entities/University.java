package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Universities", 
       indexes = { @Index(columnList = "name_university", name = "Universities_index_name_university")})
public class University {

	@Id
	@Column(name = "id_university", length = 10, nullable = false)
	private String id;


	@Column(name = "name_university", length = 50, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<UniversityDetail> universityDetail;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Quiz> quizzes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
}
