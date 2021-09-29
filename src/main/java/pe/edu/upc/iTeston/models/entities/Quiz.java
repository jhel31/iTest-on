	package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Quizzes")
public class Quiz {
	
	@Id
	@Column(name = "id_quiz", length = 10, nullable = false)
	private String id;

	@Column(name = "nota_quiz")
	private Integer nota;

	@ManyToOne
	@JoinColumn(name = "id_university", nullable = false)
	private University university;
	
	@ManyToOne
	@JoinColumn(name = "Quizzes", nullable = false)
	private Subscription subscription;
	
	@OneToOne //min 25-video 10 
	@JoinColumn(name = "id_freemium", nullable = true)
	private Freemium freemium;
	
	@OneToMany(mappedBy = "quiz")
	private List<QuestionBank>questionsBanks;
	
	
}
