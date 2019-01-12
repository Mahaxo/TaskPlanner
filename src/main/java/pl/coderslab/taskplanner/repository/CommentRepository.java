package pl.coderslab.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskplanner.model.Comment;
import pl.coderslab.taskplanner.model.User;

public interface CommentRepository extends JpaRepository<Comment, Long> {




}
