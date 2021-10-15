package pe.edu.upc.iTeston.models.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "University_Details")
public class UniversityDetail {
	@Id
	@Column(name = "id_university_details", length = 9, nullable = false)
	private String id;

	@ManyToOne
	@JoinColumn(name = "id_university", nullable = false)
	private University university;

	@ManyToOne
	@JoinColumn(name = "id_career", nullable = false)
	private Career career;
	
	public UniversityDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UniversityDetail(String id, University university, Career career) {
		super();
		this.id = id;
		this.university = university;
		this.career = career;
	}

	//gets and sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	@Override
	public int hashCode() {
		return Objects.hash(career, id, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniversityDetail other = (UniversityDetail) obj;
		return Objects.equals(career, other.career) && Objects.equals(id, other.id)
				&& Objects.equals(university, other.university);
	}

	
}
