package pe.edu.upc.iTeston.models.entities;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
	@Column(name = "id_subscription",length = 10, nullable = false)
	private String id;
	
	@Column(name = "issueDate_subcription", length = 40, nullable = false)
	private Date issueDate;
	
	@Column(name = "expire_subcription", length = 40, nullable = false)
	private Date expire;
	
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
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
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

	@Override
	public int hashCode() {
		return Objects.hash(expire, id, issueDate, paymentMethod, plan, quizzes, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		return Objects.equals(expire, other.expire) && Objects.equals(id, other.id)
				&& Objects.equals(issueDate, other.issueDate) && Objects.equals(paymentMethod, other.paymentMethod)
				&& Float.floatToIntBits(plan) == Float.floatToIntBits(other.plan)
				&& Objects.equals(quizzes, other.quizzes) && Objects.equals(student, other.student);
	}

	public Subscription(String id, Date issueDate, Date expire, PaymentMethod paymentMethod, Student student,
			List<Quiz> quizzes, float plan) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.expire = expire;
		this.paymentMethod = paymentMethod;
		this.student = student;
		this.quizzes = quizzes;
		this.plan = plan;
	}

	
	
}

