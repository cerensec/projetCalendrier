package fr.esgi.calendrier.controller.rest;

import fr.esgi.calendrier.dto.ReactionDto;
import fr.esgi.calendrier.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    private final ReactionService reactionService;

    @Autowired
    public ReactionController(final ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping("/save")
    public ResponseEntity<ReactionDto> saveReaction(@RequestBody final ReactionDto reactionDto) {
        return ResponseEntity.ok(reactionService.saveReaction(reactionDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ReactionDto> getReactionById(@PathVariable final Long id) {
        return ResponseEntity.ok(reactionService.getReactionById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReactionDto>> getAllReactions() {
        return ResponseEntity.ok(reactionService.getAllReactions());
    }

}
