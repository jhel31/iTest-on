package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne
	@JoinColumn(name = "id_freemium", nullable = false)
	private Freemium freemium;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Approval> approvals;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Freemium getFreemium() {
		return freemium;
	}

	public void setFreemium(Freemium freemium) {
		this.freemium = freemium;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvals, comments, email, freemium, id, lastname, name, password, subscriptions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(approvals, other.approvals) && Objects.equals(comments, other.comments)
				&& Objects.equals(email, other.email) && Objects.equals(freemium, other.freemium)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(subscriptions, other.subscriptions);
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, String lastname, String email, String password, Freemium freemium,
			List<Comment> comments, List<Approval> approvals, List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.freemium = freemium;
		this.comments = comments;
		this.approvals = approvals;
		this.subscriptions = subscriptions;
	}
	
}
