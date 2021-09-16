package pe.edu.upc.iTeston.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.iTeston.business.crud.CommentService;
import pe.edu.upc.iTeston.models.entities.Comment;
import pe.edu.upc.iTeston.models.repository.CommentRepository;
import pe.edu.upc.iTeston.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentRepository commentRepository;
	@Override
	public JpaRepository<Comment, Integer> getJpaRepository() {
		
		return commentRepository;
	}

}
