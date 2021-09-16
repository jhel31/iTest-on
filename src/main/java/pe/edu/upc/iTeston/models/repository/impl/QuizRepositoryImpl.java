package pe.edu.upc.iTeston.models.repository.impl;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.iTeston.models.entities.Quiz;
import pe.edu.upc.iTeston.models.repository.QuizRepository;

public class QuizRepositoryImpl implements QuizRepository{

	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {

		return entityManager;
	}
	@Override
	public Optional<Quiz> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return findById(id, Quiz.class);
	}

	@Override
	public List<Quiz> findAll() throws Exception {
		String jpql = "SELECT quiz FROM Quiz quiz ";
		return findAll(Quiz.class,jpql);
	}

}
