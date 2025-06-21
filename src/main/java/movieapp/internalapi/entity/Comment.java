package movieapp.internalapi.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Comment {
	private final int commentId;
	private String userId;
	private String movieId;
	private String commentBody;
	private LocalDateTime updateDate;
}
