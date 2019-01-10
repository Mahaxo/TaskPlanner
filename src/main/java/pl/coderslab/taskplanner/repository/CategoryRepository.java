package pl.coderslab.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskplanner.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
