package pl.coderslab.taskplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.taskplanner.dto.CommentDto;
import pl.coderslab.taskplanner.model.Comment;
import pl.coderslab.taskplanner.repository.CommentRepository;
import pl.coderslab.taskplanner.service.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements BaseService<CommentDto, Long> {

    @Autowired
    CommentRepository commentRepository;

    public List<CommentDto> getAll() {
        List<Comment> Comments = commentRepository.findAll();
        return Comments.stream().map(Comment -> Comment.toCommentDto()).collect(Collectors.toList());
    }

    public CommentDto find(Long id) {
        Comment Comment = commentRepository.findById(id).get();
        return Comment.toCommentDto();
    }

    public CommentDto save(CommentDto CommentDto) {
        Comment Comment = CommentDto.toComment();
        commentRepository.save(Comment);
        return Comment.toCommentDto();
    }

    public CommentDto update(CommentDto CommentDto, Long id) {
        Comment Comment = commentRepository.findById(id).get();
        Comment.setCreationDate(CommentDto.getCreationDate());
        Comment.setContent(CommentDto.getContent());
        commentRepository.save(Comment);
        return Comment.toCommentDto();
    }
    public Boolean remove(Long id) {
        Comment Comment = commentRepository.findById(id).get();
        commentRepository.delete(Comment);
        return true;

    }
}
