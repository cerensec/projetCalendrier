package fr.esgi.calendrier.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link fr.esgi.calendrier.business.Theme}
 */
@Data
@Builder
public class ThemeDto implements Serializable {
    Long id;
    String name;
}