package pe.edu.upc.iTeston.models.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "subcriptions")
public class Subscription {
	@Id 
	@Column(name = "id_subcription", length = 2, nullable = false)
	private String id;
	
	//private List<Quiz> quizzes;
}

