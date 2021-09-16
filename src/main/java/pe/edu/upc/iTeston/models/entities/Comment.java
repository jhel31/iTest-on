package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "Comments")

public class Comment {
	@Id 
	@Column(name = "id_comment")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	

}
