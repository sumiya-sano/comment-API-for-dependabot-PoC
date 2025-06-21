package movieapp.internalapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import movieapp.internalapi.entity.Comment;
import movieapp.internalapi.entity.CommentRegisterRequest;
import movieapp.internalapi.entity.CommentUpdateResponse;
import movieapp.internalapi.service.CommentService;

@RequestMapping("internalapi/v1/comments")
@RestController
public class CommentController {
	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("fetch/{movieId}")
	public List<Comment> fetchComments(@PathVariable int movieId) {
		return commentService.fetchByMovieId(movieId);
	}

	@PostMapping
	public ResponseEntity<CommentUpdateResponse> registerComment(
			@RequestBody CommentRegisterRequest commentRegisterRequest) {
		CommentUpdateResponse commentUpdateResponse = null;
		URI location = null;

		int createdCommentId = commentService.registerComment(commentRegisterRequest);

		//ResponseHeader, Body設定
		commentUpdateResponse = new CommentUpdateResponse("Created", createdCommentId);
		location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(createdCommentId)
				.toUri();

		return ResponseEntity.created(location).body(commentUpdateResponse);
	}

	@DeleteMapping("/{commentId}")
	public int deleteComment(@PathVariable int commentId) {
		return commentService.deleteComment(commentId);
	}
	
	@PutMapping("/{commentId}")
	public ResponseEntity<CommentUpdateResponse> editComment(@PathVariable int commentId, @RequestBody Map<String, String> commentBody) {
		CommentUpdateResponse commentUpdateResponse = null;
		Comment comment = new Comment(commentId);
		comment.setCommentBody(commentBody.get("comment_body"));
		
		int updatedCommentId = commentService.editComment(comment);
		
		//ResponseHeader, Body設定
		commentUpdateResponse = new CommentUpdateResponse("Edited", updatedCommentId);
		
		return ResponseEntity.status(204).body(commentUpdateResponse);
	}
}
