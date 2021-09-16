package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
	
	@Id
	@Column(name = "id_student", length = 20, nullable = false)
	private String id;
	
	@Column(name = "name_student", length = 100)
	private String name;
	
	@Column(name = "lastname_student", length = 100)
	private String lastname;
	
	@Column(name = "email_student", length = 40)
	private String email;
	
	@Column(name = "password_student", length = 30)
	private String password;
	
	@OneToOne
	@JoinColumn(name ="id_freemium", nullable = true)
	private Freemium freemium;

	@OneToMany (mappedBy = "student", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Approval> approvals;
	
	
	@OneToMany (mappedBy = "student", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;
	

}
