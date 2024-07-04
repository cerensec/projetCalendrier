package fr.esgi.calendrier.controller;

import fr.esgi.calendrier.dto.DayDto;
import fr.esgi.calendrier.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(final DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DayDto>> getAllDays() {
        return ResponseEntity.ok(dayService.getAllDays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayDto> getDayById(@PathVariable final Long id) {
        return ResponseEntity.ok(dayService.findDayById(id));
    }
}
