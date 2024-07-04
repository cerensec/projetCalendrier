package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.GifDto;

/**
 * The interface Gif service.
 */
public interface GifService {

    /**
     * Save gif gif dto.
     *
     * @param gifDto the gif dto
     * @return the gif dto
     */
    GifDto saveGif(GifDto gifDto);

    /**
     * Find gif by id gif dto.
     *
     * @param id the id
     * @return the gif dto
     */
    GifDto findGifById(Long id);

    /**
     * Delete gif boolean.
     *
     * @param id the id
     * @return the boolean
     */
    Boolean deleteGif(Long id);


    /**
     * Add gif to day.
     *
     * @param gifDto the gif dto
     * @param dayId  the day id
     * @param userId the user id
     * @return the boolean
     */
    Boolean addGifToDay(final GifDto gifDto, final Long dayId, final Long userId);

}
