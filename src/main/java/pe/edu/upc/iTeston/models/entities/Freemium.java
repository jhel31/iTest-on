package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Freemiums")
public class Freemium {
	@Id
	@Column(name = "id_freemium", length = 20)
	private String id;
	@OneToOne(mappedBy= "freemium" )
	private Quiz quiz;

	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@OneToOne(mappedBy = "freemium")
	private Student students;
	
}
