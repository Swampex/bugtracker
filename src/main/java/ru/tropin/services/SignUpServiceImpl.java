package ru.tropin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tropin.form.UserForm;
import ru.tropin.model.ContactUser;
import ru.tropin.model.Role;
import ru.tropin.model.State;
import ru.tropin.model.User;
import ru.tropin.repository.UsersRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        ContactUser contacts = ContactUser.builder()
                .firstName(userForm.getName()).build();

        Set<Role> roles = new HashSet<Role>();
        roles.add(Role.TESTER);
        roles.add(Role.DEVELOPER);

        User user = User.builder()
                .contactUser(contacts)
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .roles(roles)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
}
