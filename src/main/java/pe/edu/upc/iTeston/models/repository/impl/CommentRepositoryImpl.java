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
		return entityManager;
	}

	@Override
	public Optional<Comment> findById(String id) throws Exception {				
		return findById(id, Comment.class);
	}
	@Override
	public List<Comment> findByDescription(String description) throws Exception {
		String jpql = "SELECT c FROM Comments c WHERE c.description_comment LIKE '%" + description + "%'" ;
		System.out.println(jpql);
		return findAll(Comment.class, jpql);
	}

	@Override
	public List<Comment> findAll() throws Exception {
		String jpql = "SELECT comment FROM Comments comment";
		return findAll(Comment.class, jpql);
	}

}
