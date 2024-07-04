package fr.esgi.calendrier.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link fr.esgi.calendrier.business.GifReaction}
 */
@Data
@Builder
public class GifReactionDto implements Serializable {
    Long id;
    GifDto gif;
    UserDto user;
    ReactionDto reaction;
}