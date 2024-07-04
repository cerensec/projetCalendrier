package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.ThemeDto;

import java.util.List;

/**
 * The interface Theme service.
 */
public interface ThemeService {

    /**
     * Find theme by id theme dto.
     *
     * @param id the id
     * @return the theme dto
     */
    ThemeDto findThemeById(Long id);

    /**
     * Find all themes list.
     *
     * @return the list
     */
    List<ThemeDto> findAllThemes();
}
