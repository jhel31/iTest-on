package pe.edu.upc.iTeston.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teachers")
public class Teacher{
	@Id
	@Column(name = "id_teacher", length = 10, nullable = false)
	private String id;
	
	@Column(name = "name_teacher",length= 30, nullable = false)	
	private String name;
	
	@Column(name = "lastname_teacher",length= 30, nullable = false)	
	private String lastname;
	
	@Column(name = "correo_teacher",length= 100, nullable = false)	
	private String correo;
	
	@Column(name = "contrase�a",length= 30, nullable = false)	
	private String contrase�a;
	
	@OneToOne 
	@JoinColumn(name ="virtualWallet_id", nullable = true)
	private VirtualWallet virtualWallet; //virtualWallet
	
	@ManyToOne
	@JoinColumn(name ="course_id", nullable=false)
	private Course course; //course_id
}
