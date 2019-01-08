package pl.coderslab.taskplanner.dto;

import pl.coderslab.taskplanner.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String firstName;
    @NotBlank
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, @NotBlank String username, @NotBlank String firstName, @NotBlank @Email String email) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setUsername(this.getUsername());
        user.setFirstName(this.getFirstName());
        user.setEmail(this.getEmail());
        return user;
    }


}
