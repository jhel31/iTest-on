package pe.edu.upc.iTeston.models.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "subscriptions")

public class Subscription {
	@Id
	@Column(name = "id_subscription", columnDefinition="NUMERIC(40)")
	private String id;
	
	@Column(name = "issueDate_subcription", length = 40, nullable = false)
	private Date issueDate;
	
	@Column(name = "expire_subcription", length = 40, nullable = false)

	private String expire;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public float getPlan() {
		return plan;
	}

	public void setPlan(float plan) {
		this.plan = plan;
	}

	@ManyToOne
	@JoinColumn(name="id_paymentMethods")
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="id_student", nullable = false)
	private Student student;
	
	@OneToMany(mappedBy = "subscription")
	private List<Quiz> quizzes;
	
	@Column(name = "plan_price" )
	private float plan;
	
}

