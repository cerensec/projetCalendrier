package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.Day;
import fr.esgi.calendrier.dto.DayDto;
import fr.esgi.calendrier.mappers.DayMapper;
import fr.esgi.calendrier.repository.DayRepository;
import fr.esgi.calendrier.service.DayService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Day service.
 */
@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;
    private final DayMapper dayMapper;

    /**
     * Instantiates a new Day service.
     *
     * @param dayRepository the day repository
     * @param dayMapper     the day mapper
     */
    @Autowired
    public DayServiceImpl(final DayRepository dayRepository, final DayMapper dayMapper) {
        this.dayRepository = dayRepository;
        this.dayMapper = dayMapper;
    }

    @Override
    public DayDto saveDay(DayDto dayDto) {
        final Day day = dayMapper.toEntity(dayDto);
        return dayMapper.toDto(dayRepository.save(day));
    }

    @Override
    public DayDto findDayById(Long id) {
        final Day day = dayRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Day not found"));
        return dayMapper.toDto(day);
    }

    @Override
    public List<DayDto> getAllDays() {
        final List<Day> days = dayRepository.findAll();
        return dayMapper.toDtoList(days);
    }
}
