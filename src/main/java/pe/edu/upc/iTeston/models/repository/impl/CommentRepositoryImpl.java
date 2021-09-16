package pe.edu.upc.iTeston.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.repository.CommentRepository;

@Named
@ApplicationScoped
public class CommentRepositoryImpl implements CommentRepository{
	
	@PersistenceContext(unitName = "iTest-on")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public Optional<Comment> findById(Integer id) throws Exception {
		return findById(id, Comment.class);
	}

	@Override
	public List<Comment> findAll() throws Exception {
		String jpql = "SELECT comment FROM Comment comment";
		return findAll(Comment.class, jpql);
	}

}
