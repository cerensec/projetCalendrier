package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.Day;
import fr.esgi.calendrier.dto.DayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Day mapper.
 */
@Component
public class DayMapper {

    private final GifMapper gifMapper;

    /**
     * Instantiates a new Day mapper.
     *
     * @param gifMapper the gif mapper
     */
    @Autowired
    public DayMapper(final GifMapper gifMapper) {
        this.gifMapper = gifMapper;
    }

    /**
     * To dto day dto.
     *
     * @param day the day
     * @return the day dto
     */
    public DayDto toDto(final Day day) {
        return DayDto.builder()
                .id(day.getId())
                .date(day.getDate())
                .gif(day.getGif() != null ? gifMapper.toDto(day.getGif()) : null)
                .cost(day.getCost())
                .build();
    }

    /**
     * To entity day.
     *
     * @param dayDto the day dto
     * @return the day
     */
    public Day toEntity(final DayDto dayDto) {
        return Day.builder()
                .id(dayDto.getId())
                .date(dayDto.getDate())
                .gif(gifMapper.toEntity(dayDto.getGif()))
                .cost(dayDto.getCost())
                .build();
    }

    /**
     * To dto list list.
     *
     * @param days the days
     * @return the list
     */
    public List<DayDto> toDtoList(final List<Day> days) {
        return days.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
