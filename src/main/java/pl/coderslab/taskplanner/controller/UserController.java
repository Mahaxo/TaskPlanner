package pl.coderslab.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.taskplanner.dto.UserDto;
import pl.coderslab.taskplanner.model.User;
import pl.coderslab.taskplanner.service.impl.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDto> showUsers() {
        return userService.getAll();

    }
    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id) {

        return userService.find(id);
    }

    @PostMapping("")
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
        userService.save(userDto);
        return userDto;
    }
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {

        return userService.remove(id);
    }

    @PutMapping("{id}")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto, @PathVariable Long id) {

        return userService.update(userDto, id);
    }

}
