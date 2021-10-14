package pe.edu.upc.iTeston.models.repository;

import java.util.List;

import pe.edu.upc.iTeston.models.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
	List<Comment> findByDescription(String description) throws Exception;
}
