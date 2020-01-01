package ru.tropin.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.tropin.model.User;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String name;
    private String login;

    public static UserDto from(User user) {
        return UserDto.builder()
                .name(user.getContactUser().getFirstName())
                .login(user.getLogin())
                .build();
    }
}
