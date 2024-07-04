package fr.esgi.calendrier.dto;

import fr.esgi.calendrier.business.Day;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Day}
 */
@Builder
@Data
@Setter
public class DayDto implements Serializable {
    Long id;
    LocalDate date;
    GifDto gif;
}