package pe.edu.upc.iTeston.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Careers",
	indexes = { @Index(columnList = "name_career", name = "careers_index_name_career")})

public class Career {

	@Id
	@Column(name = "id_career", length = 10, nullable = false)
	private String id;
	
	@Column(name = "name_career", length = 60)
	private String name;
	
	@OneToMany(mappedBy = "career",fetch = FetchType.LAZY)
	private List<UniversityDetail> universityDetails;

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
	
	
	
}
