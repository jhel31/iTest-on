package pe.edu.upc.iTeston.models.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "subscriptions")

//*@SequenceGenerator(name="Subscriptions_subscription_id_seq",initialValue = 001,allocationSize = 1)
public class Subscription {
	@Id
	@Column(name = "subscription_id", columnDefinition="NUMERIC(4)")
	private String id;
	
	@Column(name = "subcription_issueDate", length = 9, nullable = false)
	private Date issueDate;
	
	@Column(name = "subcription_expire", length = 9, nullable = false)
	private String expire;
	
	@ManyToOne
	@JoinColumn(name="id_paymentMethods")
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	//*@JoinCoumn(name="")
	//*private Subscription subscriptions;
	//private List<Quiz> quizzes;
}

