package pl.coderslab.taskplanner.dto;

import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.taskplanner.model.Category;
import pl.coderslab.taskplanner.model.Comment;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CommentDto {

    private Long id;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @NotBlank
    private String content;

    public CommentDto() {
    }

    public CommentDto(Long id, LocalDateTime creationDate, @NotBlank String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment toComment() {
        Comment comment = new Comment();
        comment.setCreationDate(this.getCreationDate());
        comment.setContent(this.getContent());
        return comment;
    }
}
