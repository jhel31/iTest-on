package pe.edu.upc.iTeston.models.entities;

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

}
