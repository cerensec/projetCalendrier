package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.Theme;
import fr.esgi.calendrier.dto.ThemeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Theme mapper.
 */
@Component
public class ThemeMapper {

    /**
     * To dto theme dto.
     *
     * @param theme the theme
     * @return the theme dto
     */
    public ThemeDto toDto(Theme theme) {
        return ThemeDto.builder()
                .id(theme.getId())
                .name(theme.getName())
                .build();
    }

    /**
     * To entity theme.
     *
     * @param themeDto the theme dto
     * @return the theme
     */
    public Theme toEntity(ThemeDto themeDto) {
        return Theme.builder()
                .id(themeDto.getId())
                .name(themeDto.getName())
                .build();
    }

    /**
     * To dto list.
     *
     * @param themes the themes
     * @return the list
     */
    public List<ThemeDto> toDtoList(List<Theme> themes) {
        return themes.stream().map(this::toDto).collect(Collectors.toList());
    }
}
