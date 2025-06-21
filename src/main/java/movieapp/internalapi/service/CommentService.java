package movieapp.internalapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import movieapp.internalapi.entity.Comment;
import movieapp.internalapi.entity.CommentRegisterRequest;

@Service
public interface CommentService {
	public List<Comment> fetchByMovieId(int movieId);

	public int registerComment(CommentRegisterRequest commentRegisterRequest);

	public int deleteComment(int commentId);
	
	public int editComment(Comment comment);

}
