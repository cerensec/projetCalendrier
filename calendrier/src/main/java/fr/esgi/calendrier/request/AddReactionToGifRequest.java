package fr.esgi.calendrier.request;

import lombok.Data;

@Data
public class AddReactionToGifRequest {

    private Long reactionId;
    private Long gifId;
    private Long userId;
}
