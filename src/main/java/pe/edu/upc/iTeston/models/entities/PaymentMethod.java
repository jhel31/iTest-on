package pe.edu.upc.iTeston.models.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

	@Column(name = "expire_date")
	@Temporal(TemporalType.DATE)
	private Date date;

	public PaymentMethod(String id, int numberCard, int codeCard, Date date, List<Subscription> subscriptions) {
		super();
		this.id = id;
		this.numberCard = numberCard;
		this.codeCard = codeCard;
		this.date = date;
		this.subscriptions = subscriptions;
	}

	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(int numberCard) {
		this.numberCard = numberCard;
	}

	public int getCodeCard() {
		return codeCard;
	}

	public void setCodeCard(int codeCard) {
		this.codeCard = codeCard;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY)
	private List<Subscription> subscriptions;

	@Override
	public int hashCode() {
		return Objects.hash(codeCard, date, id, numberCard, subscriptions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethod other = (PaymentMethod) obj;
		return codeCard == other.codeCard && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& numberCard == other.numberCard && Objects.equals(subscriptions, other.subscriptions);
	}

}
