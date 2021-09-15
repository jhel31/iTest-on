package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UniversityDetails")
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

}
