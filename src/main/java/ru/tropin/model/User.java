package ru.tropin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tropin.form.UserForm;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ContactUser contactUser;

    private String login;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    public static User from(UserForm form) {
        ContactUser contacts = ContactUser.builder()
                .firstName(form.getName()).build();
        return User.builder()
                .contactUser(contacts)
                .build();
    }
}
