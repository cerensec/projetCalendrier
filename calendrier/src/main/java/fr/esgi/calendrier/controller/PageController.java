package fr.esgi.calendrier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/page1")
    public String getPage1(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 1!");
        return "page1";
    }

    @GetMapping("/page2")
    public String getPage2(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 2!");
        return "page2";
    }

    @GetMapping("/page3")
    public String getPage3(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 3!");
        return "page3";
    }
}

