package ru.tropin.form;

import lombok.Data;
import ru.tropin.model.Role;
import ru.tropin.model.State;

import java.util.Set;

@Data
public class ProfileForm {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String login;
    private String state;
    private String role_TESTER;
    private String role_ADMIN;
    private String role_DEVELOPER;
}
