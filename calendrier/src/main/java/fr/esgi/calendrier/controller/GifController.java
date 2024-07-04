package fr.esgi.calendrier.controller;

import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.request.AddGifToDayRequest;
import fr.esgi.calendrier.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gif")
public class GifController {

    private final GifService gifService;

    @Autowired
    public GifController(final GifService gifService) {
        this.gifService = gifService;
    }

    @PostMapping("/save")
    public ResponseEntity<GifDto> saveGif(@RequestBody final GifDto gifDto) {
        return ResponseEntity.ok(gifService.saveGif(gifDto));
    }

    @PostMapping("/addGifToDay")
    public ResponseEntity<Boolean> addGifToDay(@RequestBody final AddGifToDayRequest request) {
        final Boolean result = gifService.addGifToDay(request.getGifDto(), request.getDayId(), request.getUserId());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GifDto> getGifById(@PathVariable final Long id) {
        return ResponseEntity.ok(gifService.findGifById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteGif(@PathVariable final Long id) {
        return ResponseEntity.ok(gifService.deleteGif(id));
    }



}
