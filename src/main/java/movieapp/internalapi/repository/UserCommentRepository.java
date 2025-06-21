package movieapp.internalapi.repository;

import java.util.List;

import movieapp.internalapi.entity.Comment;
import movieapp.internalapi.entity.CommentRegisterRequest;

public interface UserCommentRepository {
	List<Comment> selectByMovieId(int movieId);

	int insert(CommentRegisterRequest commentRegisterRequest);

	int deleteComment(int commentId);

	int updateCommentBody(Comment comment);
}
