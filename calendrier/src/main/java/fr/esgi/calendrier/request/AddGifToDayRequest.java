package fr.esgi.calendrier.request;

import fr.esgi.calendrier.dto.GifDto;
import lombok.Data;

@Data
public class AddGifToDayRequest {

    private GifDto gifDto;
    private Long dayId;
    private Long userId;

}
