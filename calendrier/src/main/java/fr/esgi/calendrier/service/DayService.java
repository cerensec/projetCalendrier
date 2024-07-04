package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.DayDto;

import java.util.List;

/**
 * The interface Day service.
 */
public interface DayService {

    /**
     * Save day day dto.
     *
     * @param dayDto the day dto
     * @return the day dto
     */
    DayDto saveDay(DayDto dayDto);
    /**
     * Find day by id day dto.
     *
     * @param id the id
     * @return the day dto
     */
    DayDto findDayById(Long id);

    /**
     * Gets all days.
     *
     * @return the all days
     */
    List<DayDto> getAllDays();
}
