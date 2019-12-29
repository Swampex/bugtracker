package ru.tropin.form;

import lombok.Builder;
import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String login;
    private String password;
}
