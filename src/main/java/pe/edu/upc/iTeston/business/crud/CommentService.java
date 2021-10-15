package pe.edu.upc.iTeston.business.crud;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Comment;

public interface CommentService extends CrudService<Comment, String> {
	List<Comment> findByDescription(String description) throws Exception;
}
