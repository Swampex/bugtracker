package ru.tropin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tropin.form.ProfileForm;
import ru.tropin.model.ContactUser;
import ru.tropin.model.Role;
import ru.tropin.model.State;
import ru.tropin.model.User;
import ru.tropin.repository.UsersRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void updateProfile(ProfileForm profileForm, Long id) {
        User user = usersRepository.findOne(id);

        ContactUser contacts = ContactUser.builder()
                .firstName(profileForm.getFirstName())
                .lastName(profileForm.getLastName())
                .phoneNumber(profileForm.getPhoneNumber())
                .build();

        Set<Role> roles = new HashSet<>();
        if(profileForm.getRole_ADMIN()!=null) {
            roles.add(Role.ADMIN);
        }
        if(profileForm.getRole_DEVELOPER()!=null) {
            roles.add(Role.DEVELOPER);
        }
        if(profileForm.getRole_TESTER()!=null) {
            roles.add(Role.TESTER);
        }

        user.setContactUser(contacts);
        user.setLogin(profileForm.getLogin());
//        user.setState(profileForm.getState());
        user.setRoles(roles);
        usersRepository.save(user);
    }
}
