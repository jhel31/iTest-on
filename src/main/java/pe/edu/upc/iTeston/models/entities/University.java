package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

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
	
	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(String id, String name, List<UniversityDetail> universityDetail, List<Quiz> quizzes) {
		super();
		this.id = id;
		this.name = name;
		this.universityDetail = universityDetail;
		this.quizzes = quizzes;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, quizzes, universityDetail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(quizzes, other.quizzes) && Objects.equals(universityDetail, other.universityDetail);
	}
	
	
}
