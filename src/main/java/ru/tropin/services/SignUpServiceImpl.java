package ru.tropin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tropin.form.UserForm;
import ru.tropin.model.Role;
import ru.tropin.model.State;
import ru.tropin.model.User;
import ru.tropin.repository.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .name(userForm.getName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.DEVELOPER)
                .state(State.ACTIVE)
                .build();
        usersRepository.save(user);
    }
}
