package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
	
	@Id
	@Column(name = "student_id", length = 20, nullable = false)
	private String id;
	
	@Column(name = "student_name", length = 100)
	private String name;
	
	@Column(name = "student_lastname", length = 100)
	private String lastname;
	
	@Column(name = "student_email", length = 40)
	private String email;
	
	@Column(name = "student_password", length = 30)
	private String password;
	
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Approval> approvals;
	
	@OneToMany (mappedBy = "student", fetch = FetchType.LAZY)
	private List<Subscription> subscription;
	
	@OneToMany (mappedBy = "student", fetch = FetchType.LAZY)
	private List<Comment> comment;
	

}
