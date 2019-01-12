package pl.coderslab.taskplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.taskplanner.dto.CategoryDto;
import pl.coderslab.taskplanner.model.Category;
import pl.coderslab.taskplanner.repository.CategoryRepository;
import pl.coderslab.taskplanner.service.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements BaseService<CategoryDto, Long> {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        List<Category> Categorys = categoryRepository.findAll();
        return Categorys.stream().map(Category -> Category.toCategoryDto()).collect(Collectors.toList());
    }

    public CategoryDto find(Long id) {
        Category Category = categoryRepository.findById(id).get();
        return Category.toCategoryDto();
    }

    public CategoryDto save(CategoryDto CategoryDto) {
        Category Category = CategoryDto.toCategory();
        categoryRepository.save(Category);
        return Category.toCategoryDto();
    }

    public CategoryDto update(CategoryDto CategoryDto, Long id) {
        Category Category = categoryRepository.findById(id).get();
        Category.setName(CategoryDto.getName());
        categoryRepository.save(Category);
        return Category.toCategoryDto();
    }
    public Boolean remove(Long id) {
        Category Category = categoryRepository.findById(id).get();
        categoryRepository.delete(Category);
        return true;

    }



}
