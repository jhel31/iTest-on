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
	
	@Column(name = "correct_alternative", length = 500)
	private String correctAlternative;
	
	@Column(name = "wrong_alternative_1", length = 500)
	private String wrongAlternative1;
	
	@Column(name = "wrong_alternative_2", length = 500)
	private String wrongAlternative2;
	
	@Column(name = "wrong_alternative_3", length = 500)
	private String wrongAlternative3;
	
	@Column(name = "wrong_alternative_4", length = 500)
	private String wrongAlternative4;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCorrectAlternative() {
		return correctAlternative;
	}

	public void setCorrectAlternative(String correctAlternative) {
		this.correctAlternative = correctAlternative;
	}

	public String getWrongAlternative1() {
		return wrongAlternative1;
	}

	public void setWrongAlternative1(String wrongAlternative1) {
		this.wrongAlternative1 = wrongAlternative1;
	}

	public String getWrongAlternative2() {
		return wrongAlternative2;
	}

	public void setWrongAlternative2(String wrongAlternative2) {
		this.wrongAlternative2 = wrongAlternative2;
	}

	public String getWrongAlternative3() {
		return wrongAlternative3;
	}

	public void setWrongAlternative3(String wrongAlternative3) {
		this.wrongAlternative3 = wrongAlternative3;
	}

	public String getWrongAlternative4() {
		return wrongAlternative4;
	}

	public void setWrongAlternative4(String wrongAlternative4) {
		this.wrongAlternative4 = wrongAlternative4;
	}
	
	
}
