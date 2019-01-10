package pl.coderslab.taskplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.taskplanner.dto.UserDto;
import pl.coderslab.taskplanner.model.User;
import pl.coderslab.taskplanner.repository.UserRepository;
import pl.coderslab.taskplanner.service.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService<UserDto, Long> {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> user.toUserDto()).collect(Collectors.toList());
    }

    public UserDto find(Long id) {
        User user = userRepository.findById(id).get();
        return user.toUserDto();
    }

    public UserDto save(UserDto userDto) {
        User user = userDto.toUser();
        userRepository.save(user);
        return user.toUserDto();
    }

    public UserDto update(UserDto userDto, Long id) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return user.toUserDto();
    }
    public Boolean remove(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;

    }

}
