package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.Theme;
import fr.esgi.calendrier.dto.ThemeDto;
import fr.esgi.calendrier.mappers.ThemeMapper;
import fr.esgi.calendrier.repository.ThemeRepository;
import fr.esgi.calendrier.service.ThemeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Theme service.
 */
@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    private final ThemeMapper themeMapper;

    /**
     * Instantiates a new Theme service.
     *
     * @param themeRepository the theme repository
     * @param themeMapper     the theme mapper
     */
    @Autowired
    public ThemeServiceImpl(ThemeRepository themeRepository, ThemeMapper themeMapper) {
        this.themeRepository = themeRepository;
        this.themeMapper = themeMapper;
    }

    @Override
    public ThemeDto findThemeById(Long id) {
        final Theme theme = themeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theme not found with id: " + id));
        return themeMapper.toDto(theme);
    }

    @Override
    public List<ThemeDto> findAllThemes() {
        final List<Theme> themes = themeRepository.findAll();
        return themeMapper.toDtoList(themes);
    }
}
