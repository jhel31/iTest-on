	package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	
	@OneToMany(mappedBy = "quiz")
	private List<QuestionBank>questionsBanks;
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(String id, Integer nota, University university, Subscription subscription, Freemium freemium,
			List<QuestionBank> questionsBanks) {
		super();
		this.id = id;
		this.nota = nota;
		this.university = university;
		this.subscription = subscription;
		this.questionsBanks = questionsBanks;
	}

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

	public List<QuestionBank> getQuestionsBanks() {
		return questionsBanks;
	}

	public void setQuestionsBanks(List<QuestionBank> questionsBanks) {
		this.questionsBanks = questionsBanks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nota, questionsBanks, subscription, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		return Objects.equals(id, other.id) && Objects.equals(nota, other.nota)
				&& Objects.equals(questionsBanks, other.questionsBanks)
				&& Objects.equals(subscription, other.subscription) && Objects.equals(university, other.university);
	}

	
}
