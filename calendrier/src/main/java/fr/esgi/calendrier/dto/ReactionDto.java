package fr.esgi.calendrier.dto;

import fr.esgi.calendrier.business.Reaction;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Reaction}
 */
@Data
@Builder
public class ReactionDto implements Serializable {
    Long id;
    String name;
    @NotNull
    String emoji;
}