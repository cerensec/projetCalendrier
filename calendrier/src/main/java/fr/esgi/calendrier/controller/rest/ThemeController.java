package fr.esgi.calendrier.controller.rest;

import fr.esgi.calendrier.dto.ThemeDto;
import fr.esgi.calendrier.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(final ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ThemeDto>> getAllThemes() {
        return ResponseEntity.ok(themeService.findAllThemes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDto> getThemeById(@PathVariable final Long id) {
        return ResponseEntity.ok(themeService.findThemeById(id));
    }
}
