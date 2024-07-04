package fr.esgi.calendrier.controller;

import fr.esgi.calendrier.dto.GifReactionDto;
import fr.esgi.calendrier.request.AddReactionToGifRequest;
import fr.esgi.calendrier.service.GifReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gif-reaction")
public class GifReactionController {

    private final GifReactionService gifReactionService;

    @Autowired
    public GifReactionController(final GifReactionService gifReactionService) {
        this.gifReactionService = gifReactionService;
    }

    @PostMapping("/addReactionToGif")
    public ResponseEntity<GifReactionDto> save(@RequestBody final AddReactionToGifRequest request) {
        return ResponseEntity.ok(gifReactionService.saveGifReaction(request));
    }

    @GetMapping("/allByGifId/{gifId}")
    public ResponseEntity<List<GifReactionDto>> getAllByGifId(@PathVariable final Long gifId) {
        return ResponseEntity.ok(gifReactionService.findAllGifReactionsByGifId(gifId));
    }


}
