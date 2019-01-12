package pl.coderslab.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.taskplanner.dto.CategoryDto;
import pl.coderslab.taskplanner.service.impl.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDto> showUsers() {
        return categoryService.getAll();

    }
    @GetMapping("/{id}")
    public CategoryDto findUserById(@PathVariable Long id) {

        return categoryService.find(id);
    }

    @PostMapping("")
    public CategoryDto saveUser(@RequestBody @Valid CategoryDto CategoryDto) {
        categoryService.save(CategoryDto);
        return CategoryDto;
    }
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {

        return categoryService.remove(id);
    }

    @PutMapping("{id}")
    public CategoryDto updateUser(@RequestBody @Valid CategoryDto CategoryDto, @PathVariable Long id) {

        return categoryService.update(CategoryDto, id);
    }
}
