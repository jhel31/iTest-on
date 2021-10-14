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
	@Column(name = "id_subscription",length = 10, nullable = false)
	private String id;
	
	@Column(name = "issueDate_subcription", length = 20, nullable = false)
	private Date issueDate;
	
	@Column(name = "expire_subcription", length = 20, nullable = false)
	private String expire;
	
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

