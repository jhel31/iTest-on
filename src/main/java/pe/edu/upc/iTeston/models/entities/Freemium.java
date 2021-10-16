package pe.edu.upc.iTeston.models.entities;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Freemiums")
public class Freemium {
	@Id
	@Column(name = "id_freemium", length = 20)
	private String id;


	@Column(name = "active", nullable = false)
	private Boolean active;


	@OneToMany(mappedBy = "freemium")
	private List<Student> students;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, id, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Freemium other = (Freemium) obj;
		return Objects.equals(active, other.active) && Objects.equals(id, other.id)
				&& Objects.equals(students, other.students);
	}

	public Freemium(String id, Boolean active, List<Student> students) {
		super();
		this.id = id;
		this.active = active;
		this.students = students;
	}

	public Freemium() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	
}
