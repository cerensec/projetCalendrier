package fr.esgi.calendrier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/connexion")
    public String getConnexion(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 1!");
        return "connexion";
    }

    @GetMapping("/inscription")
    public String getInscription(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 2!");
        return "inscription";
    }

    @GetMapping("/calendrier")
    public String getCalendrier(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 3!");
        return "calendrier";
    }

    @GetMapping("/placer-gif")
    public String getPlacerGif(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 3!");
        return "placer-gif";
    }

    @GetMapping("/televerser-gif")
    public String getTeleverserGif(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 3!");
        return "televerser-gif";
    }

    @GetMapping("/reagir-gif")
    public String getReagirGif(Model model) {
        model.addAttribute("message", "Bienvenue sur la page 3!");
        return "reagir-gif";
    }
}

