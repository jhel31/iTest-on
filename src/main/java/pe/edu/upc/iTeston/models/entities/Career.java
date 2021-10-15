package pe.edu.upc.iTeston.models.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Careers", indexes = { @Index(columnList = "name_career", name = "careers_index_name_career") })

public class Career {

	@Id
	@Column(name = "id_career", length = 10, nullable = false)
	private String id;

	@Column(name = "name_career", length = 60)
	private String name;

	@OneToMany(mappedBy = "career", fetch = FetchType.LAZY)
	private List<UniversityDetail> universityDetails;

	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Career(String id, String name, List<UniversityDetail> universityDetails) {
		super();
		this.id = id;
		this.name = name;
		this.universityDetails = universityDetails;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, universityDetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Career other = (Career) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(universityDetails, other.universityDetails);
	}

}
