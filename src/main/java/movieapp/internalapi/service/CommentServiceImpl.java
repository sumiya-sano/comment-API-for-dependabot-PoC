package movieapp.internalapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movieapp.internalapi.entity.Comment;
import movieapp.internalapi.entity.CommentRegisterRequest;
import movieapp.internalapi.repository.UserCommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	private final UserCommentRepository userCommentRepository;

	public CommentServiceImpl(UserCommentRepository userCommentRepository) {
		this.userCommentRepository = userCommentRepository;
	}

	@Override
	public List<Comment> fetchByMovieId(int movieId) {
		List<Comment> commentList = userCommentRepository.selectByMovieId(movieId);
		return commentList;
	}

	@Override
	@Transactional
	public int registerComment(CommentRegisterRequest commentRegisterRequest) {
		return userCommentRepository.insert(commentRegisterRequest);
	}

	public int deleteComment(int commentId) {
		int deleteRecord = userCommentRepository.deleteComment(commentId);
		return deleteRecord;
	}
	
	@Transactional
	@Override
	public int editComment(Comment comment) {
		int commentId = userCommentRepository.updateCommentBody(comment);
		return commentId;
	}

}
