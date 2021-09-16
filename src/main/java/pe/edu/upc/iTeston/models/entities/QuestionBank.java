package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Question_Banks")
public class QuestionBank {
	@Id
	@Column(name = "id_question_bank", length = 8, nullable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_quiz", nullable = false)
	private Quiz quiz;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_teacher", nullable = false)
	private Teacher teacher;
	
	@Column(name = "description", length = 100)
	private String description;
	
	@Column(name = "results", columnDefinition = "DECIMAL(3,2)")
	private Float results;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@OneToMany(mappedBy = "questionBank")
	private List<Exercise> exercises;
	
	@OneToMany(mappedBy = "questionBank")
	private List<Approval> approvals;
	
	@OneToMany(mappedBy = "questionBank")
	private List<Comment> comments;
	
	
}
