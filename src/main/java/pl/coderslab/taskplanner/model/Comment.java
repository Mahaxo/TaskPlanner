package pl.coderslab.taskplanner.model;

import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.taskplanner.dto.CommentDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @NotBlank
    private String content;

    public Comment() {
    }

    public Comment(LocalDateTime creationDate, @NotBlank String content) {
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

    public CommentDto toCommentDto() {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(this.getId());
        commentDto.setCreationDate(this.getCreationDate());
        commentDto.setContent(this.getContent());
        return commentDto;
    }
}
