package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     * Save gif file gif dto.
     *
     * @param file the file
     * @return the gif dto
     * @throws IOException the io exception
     */
    GifDto saveGifFile(MultipartFile file, UserDto userDto) throws IOException;

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

    /**
     * Add gif file to day boolean.
     *
     * @param userId the user id
     * @param file   the file
     * @param dayId  the day id
     * @return the boolean
     * @throws IOException the io exception
     */
    Boolean addGifFileToDay(final Long userId, final MultipartFile file, final Long dayId) throws IOException;

}
