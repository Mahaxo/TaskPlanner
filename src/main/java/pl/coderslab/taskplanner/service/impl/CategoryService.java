package pl.coderslab.taskplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.taskplanner.model.Category;
import pl.coderslab.taskplanner.repository.CategoryRepository;
import pl.coderslab.taskplanner.service.BaseService;

@Service
public class CategoryService implements BaseService<Category, Long> {

    @Autowired
    CategoryRepository categoryRepository;
}
