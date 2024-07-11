package fr.esgi.calendrier.controller;

import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.request.AddGifToDayRequest;
import fr.esgi.calendrier.service.GifService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/gif")
@Log4j2
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

    @PostMapping("/addGifFileToDay")
    public ResponseEntity<Boolean> addGiftFileToDay(
            @RequestParam("userId") Long userId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("dayId") Long dayId) {

        try {
            final Boolean result = gifService.addGifFileToDay(userId, file, dayId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Error while adding gif to day", e);
            return ResponseEntity.badRequest().build();
        }
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
