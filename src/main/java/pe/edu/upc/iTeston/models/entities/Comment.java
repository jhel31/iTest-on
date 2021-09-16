package pe.edu.upc.iTeston.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Integer id;
	
	@Column(name = "description", length = 1000)
	private String description;
	
	@Column(name = "comment_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_student", nullable = true)
	//private Student student;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_question_bank", nullable = true)
	//private QuestionBank questionBank;
	
	
}
