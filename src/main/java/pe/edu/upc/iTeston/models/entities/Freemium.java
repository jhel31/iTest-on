package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Freemiums")
public class Freemium {
	@Id
	@Column(name = "id_freemium", length = 20)
	private String id;
	@OneToOne(mappedBy= "freemium" )
	private Quiz quiz;

	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@OneToOne(mappedBy = "freemium")
	private Student students;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}
}
