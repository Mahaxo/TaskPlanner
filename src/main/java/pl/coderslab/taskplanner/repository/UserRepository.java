package pl.coderslab.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskplanner.model.User;

public interface UserRepository extends JpaRepository<User, Long> {




}
