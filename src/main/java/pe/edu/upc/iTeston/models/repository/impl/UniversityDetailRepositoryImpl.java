package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.iTeston.models.entities.UniversityDetail;
import pe.edu.upc.iTeston.models.repository.UniversityDetailRepository;
@Named
@ApplicationScoped
public class UniversityDetailRepositoryImpl implements UniversityDetailRepository {

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<UniversityDetail> findById(String id) throws Exception {
		return findById(id,UniversityDetail.class);
	}

	@Override
	public List<UniversityDetail> findAll() throws Exception {
		String jpql = "SELECT universitydetail FROM UniversityDetail universitydetail ";

		return findAll(UniversityDetail.class,jpql);
	}

	

}
