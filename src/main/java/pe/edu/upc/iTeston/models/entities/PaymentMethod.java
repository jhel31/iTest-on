package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name = "PaymentMethods")

public class PaymentMethod {
	
	@Id 
	@Column(name = "id_paymentMethods", length = 10, nullable = false)
	private String id;
	
	@Transient
	private int numberCard;
	
	@Transient
	private int codeCard;
	
	@Column(name = "pay_Subcription", nullable = false)
	private float pay;
	
	@Column(name = "expire_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy="paymentMethod", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

}
