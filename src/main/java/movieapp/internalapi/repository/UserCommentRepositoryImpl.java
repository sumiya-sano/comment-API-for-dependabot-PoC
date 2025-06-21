package movieapp.internalapi.repository;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import movieapp.internalapi.entity.Comment;
import movieapp.internalapi.entity.CommentRegisterRequest;

@Repository
public class UserCommentRepositoryImpl implements UserCommentRepository {

	private final JdbcTemplate jdbcTemplate;

	public UserCommentRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Comment> selectByMovieId(int movieId) {
		List<Comment> commentList = jdbcTemplate.query(
				"SELECT * FROM comments WHERE movie_id = ?",
				new DataClassRowMapper<>(Comment.class),
				movieId);
		return commentList;
	}

	@Override
	public int insert(CommentRegisterRequest commentRegisterRequest) {
		int createdCommentId = 0;

		jdbcTemplate.update(""
				+ "INSERT INTO comments(user_id, movie_id, comment_body)"
				+ "VALUES(?, ?, ?)", commentRegisterRequest.getUserId(), commentRegisterRequest.getMovieId(),
				commentRegisterRequest.getCommentBody());

		createdCommentId = jdbcTemplate.queryForObject(" SELECT LAST_INSERT_ID()", Integer.class);

		return createdCommentId;
	}

	@Override
	public int deleteComment(int commentId) {
		int deleteRecord = jdbcTemplate.update(
				"DELETE FROM comments WHERE comment_id = ?",
				commentId);
		return deleteRecord;
	}

	@Override
	public int updateCommentBody(Comment comment) {
		jdbcTemplate.update(""
				+ "UPDATE comments "
				+ "SET comment_body=? "
				+ "WHERE comment_id=?"
				, comment.getCommentBody(), comment.getCommentId());
		
		return comment.getCommentId();
	}

}
