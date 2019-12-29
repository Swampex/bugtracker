package ru.tropin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tropin.security.details.UserDetailsImpl;
import ru.tropin.transfer.UserDto;

import static ru.tropin.transfer.UserDto.from;

@Controller
public class ProfileController {

    @GetMapping("/")
    public String getProfilePage(Authentication authentication, ModelMap modelMap) {
        if (authentication==null) {
            return  "redirect:/login";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserDto userDto = from(userDetails.getUser());
        modelMap.addAttribute("user", userDto);
        return "profile";
    }
}
