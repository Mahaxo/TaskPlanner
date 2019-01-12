package pl.coderslab.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.taskplanner.dto.CategoryDto;
import pl.coderslab.taskplanner.dto.CommentDto;
import pl.coderslab.taskplanner.service.impl.CommentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("")
    public List<CommentDto> showUsers() {
        return commentService.getAll();

    }
    @GetMapping("/{id}")
    public CommentDto findUserById(@PathVariable Long id) {

        return commentService.find(id);
    }

    @PostMapping("")
    public CommentDto saveUser(@RequestBody @Valid CommentDto commentDto) {
        commentService.save(commentDto);
        return commentDto;
    }
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {

        return commentService.remove(id);
    }

    @PutMapping("{id}")
    public CommentDto updateUser(@RequestBody @Valid CommentDto commentDto, @PathVariable Long id) {

        return commentService.update(commentDto, id);
    }
}
