package ru.tropin.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.tropin.model.Role;
import ru.tropin.model.State;
import ru.tropin.model.User;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private State state;
    private String login;
    private Set<Role> roles;
    private Long id;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getContactUser().getFirstName())
                .lastName(user.getContactUser().getLastName())
                .phoneNumber(user.getContactUser().getPhoneNumber())
                .login(user.getLogin())
                .state(user.getState())
                .roles(user.getRoles())
                .id(user.getId())
                .build();
    }
}