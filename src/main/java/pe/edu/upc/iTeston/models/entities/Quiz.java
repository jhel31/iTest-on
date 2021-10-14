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
	@JoinColumn(name = "id_subscription", nullable = false)
	private Subscription subscription;
	
	@OneToOne //min 25-video 10 
	@JoinColumn(name = "id_freemium", nullable = true)
	private Freemium freemium;
	
	@OneToMany(mappedBy = "quiz")
	private List<QuestionBank>questionsBanks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Freemium getFreemium() {
		return freemium;
	}

	public void setFreemium(Freemium freemium) {
		this.freemium = freemium;
	}

	public List<QuestionBank> getQuestionsBanks() {
		return questionsBanks;
	}

	public void setQuestionsBanks(List<QuestionBank> questionsBanks) {
		this.questionsBanks = questionsBanks;
	}
	
	
}
