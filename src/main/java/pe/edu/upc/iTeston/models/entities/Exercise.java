package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Exercises")
public class Exercise {
	@Id
	@Column(name = "id_exercise", length = 10, nullable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question_bank", nullable = false)
	private QuestionBank questionBank; 
	
	@Column(name = "statement_exercise", length = 1000)
	private String statement;
	
	@Column(name = "score_exercise")
	private Integer score;
	
	@Column(name = "correct_alternative", length = 100)
	private String correctAlternative;
	
	@Column(name = "wrong_alternative_1", length = 100)
	private String wrongAlternative1;
	
	@Column(name = "wrong_alternative_2", length = 100)
	private String wrongAlternative2;
	
	@Column(name = "wrong_alternative_3", length = 100)
	private String wrongAlternative3;
	
	@Column(name = "wrong_alternative_4", length = 100)
	private String wrongAlternative4;
}
