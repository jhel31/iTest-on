package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Approvals")
public class Approval {
	@Id
	@Column(name = "id_approval", length = 20, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_student", nullable = true)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question_bank", nullable = true)
	private QuestionBank questionBank;

	@Column(name = "level_approval")
	private Integer approvalLevel;

	@Column(name = "date_approval")
	@Temporal(TemporalType.DATE)
	private Date approvalDate;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(String id, Student student, QuestionBank questionBank, Integer approvalLevel, Date approvalDate) {
		super();
		this.id = id;
		this.student = student;
		this.questionBank = questionBank;
		this.approvalLevel = approvalLevel;
		this.approvalDate = approvalDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getApprovalLevel() {
		return approvalLevel;
	}

	public void setApprovalLevel(Integer approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvalDate, approvalLevel, id, questionBank, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Approval other = (Approval) obj;
		return Objects.equals(approvalDate, other.approvalDate) && Objects.equals(approvalLevel, other.approvalLevel)
				&& Objects.equals(id, other.id) && Objects.equals(questionBank, other.questionBank)
				&& Objects.equals(student, other.student);
	}

}
