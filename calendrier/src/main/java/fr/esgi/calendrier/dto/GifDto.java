package fr.esgi.calendrier.dto;

import fr.esgi.calendrier.business.Gif;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Gif}
 */
@Data
@Builder
public class GifDto implements Serializable {
    Long id;
    @Pattern(message = "URL must end with .gif", regexp = "^.+\\.(?i)(gif)$")
    String url;
    String legend;
    LocalDate uploadDate;
    @NotNull
    UserDto uploadUser;
}