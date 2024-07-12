package fr.esgi.calendrier.controller;

import fr.esgi.calendrier.controller.rest.AbstractGeneralController;
import fr.esgi.calendrier.dto.ThemeDto;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.request.SaveUserRequest;
import fr.esgi.calendrier.service.ThemeService;
import fr.esgi.calendrier.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
public class ThymeLeafController extends AbstractGeneralController {

    private final ThemeService themeService;
    private final UserService userService;

    @GetMapping("/signup")
    public String Form(Model model) {
        final List<ThemeDto> themes = themeService.findAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping("/signup")
    public String signup(SaveUserRequest request) {
        userService.saveUser(request);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }



}
