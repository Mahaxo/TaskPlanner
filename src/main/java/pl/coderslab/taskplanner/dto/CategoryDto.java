package pl.coderslab.taskplanner.dto;

import pl.coderslab.taskplanner.model.Category;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    private Long id;
    @NotBlank
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(Long id, @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setName(this.getName());
        return category;
    }
}
