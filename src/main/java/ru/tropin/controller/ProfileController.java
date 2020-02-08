package ru.tropin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tropin.form.ProfileForm;
import ru.tropin.model.Role;
import ru.tropin.model.User;
import ru.tropin.repository.UsersRepository;
import ru.tropin.security.details.UserDetailsImpl;
import ru.tropin.services.ProfileService;
import ru.tropin.transfer.UserDto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.tropin.transfer.UserDto.from;

@Controller
public class ProfileController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/")
    public String getProfilePage(Authentication authentication, ModelMap modelMap) {
        if (authentication==null) {
            return  "redirect:/login";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = usersRepository.findOne(userDetails.getUser().getId());
        UserDto userDto = from(user);
        modelMap.addAttribute("user", userDto);
        return "profiles/profile";
    }

    @GetMapping("/profiles")
    public String getProfiles(ModelMap modelMap) {
        modelMap.addAttribute("users", usersRepository.findAll());
        return "profiles/profilesList";
    }

    @GetMapping(value = "/profileSettings", params = "id")
    public String getProfileSettingsPage(Authentication authentication, ModelMap modelMap, @RequestParam Long id) {
        User user = usersRepository.findOne(id);
        UserDto userDto = from(user);
        modelMap.addAttribute("user", userDto);

        Set<Role> userRoles = user.getRoles();
        Map<Role, Boolean> rolesStates = Arrays.stream(Role.values())
                .collect(Collectors.toMap(
                        Function.identity(),
                        userRoles::contains
                ));
        modelMap.addAttribute("userRolesStates", rolesStates);
        return "profiles/profileSettings";
    }

    @PostMapping(value = "/profileSettings", params = "id")
    public String updateProfile(ModelMap modelMap, @RequestParam Long id, ProfileForm profileForm) {
        User user = usersRepository.findOne(id);
        profileService.updateProfile(profileForm, id);
        return "redirect:/profileSettings?id="+id;
    }

    @PostMapping(value = "/profileSimpleSettings", params = "id")
    public String updateProfileSimple(ModelMap modelMap, @RequestParam Long id, ProfileForm profileForm) {
        profileService.updateProfileSimple(profileForm, id);
        return "redirect:/";
    }
}