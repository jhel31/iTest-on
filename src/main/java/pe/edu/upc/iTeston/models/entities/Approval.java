package pe.edu.upc.iTeston.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Approvals")
public class Approval {
	@Id
	@Column(name = "id_approval", length = 20, nullable = false)
	private String id;
	
	//@Column(name = "id_student")
	//private Student student;
	
	//@Column(name = "id_question_bank")
	//private QuestionBank questionBank;
	
	@Column(name = "approval_level")
	private Integer approvalLevel;
	
	@Column(name="approval_date")
	@Temporal(TemporalType.DATE)
	private Date approvalDate;
}
