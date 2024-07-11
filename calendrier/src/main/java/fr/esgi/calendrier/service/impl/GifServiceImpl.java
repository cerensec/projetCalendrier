package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.Gif;
import fr.esgi.calendrier.dto.DayDto;
import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.mappers.GifMapper;
import fr.esgi.calendrier.mappers.UserMapper;
import fr.esgi.calendrier.repository.GifRepository;
import fr.esgi.calendrier.service.DayService;
import fr.esgi.calendrier.service.GifService;
import fr.esgi.calendrier.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 * The type Gif service.
 */
@Service
public class GifServiceImpl implements GifService {

    private static final String FILE_LOCATION = "src/main/resources/static/gifs";
    private final GifRepository gifRepository;
    private final GifMapper gifMapper;
    private final DayService dayService;
    private final UserService userService;
    private final UserMapper userMapper;

    /**
     * Instantiates a new Gif service.
     *
     * @param gifRepository the gif repository
     * @param gifMapper     the gif mapper
     */
    @Autowired
    public GifServiceImpl(final GifRepository gifRepository, final GifMapper gifMapper,
                          final DayService dayService, final UserService userService, final UserMapper userMapper) {
        this.gifRepository = gifRepository;
        this.gifMapper = gifMapper;
        this.dayService = dayService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public GifDto saveGif(GifDto gifDto) {
        final Gif gif = gifMapper.toEntity(gifDto);
        return gifMapper.toDto(gifRepository.save(gif));
    }

    @Override
    public GifDto saveGifFile(final MultipartFile file, final UserDto userDto) throws IOException {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        if (!file.getOriginalFilename().endsWith(".gif")) {
            throw new IllegalArgumentException("File is not a gif");
        }

        final Path targetLocation = Path.of(FILE_LOCATION, file.getOriginalFilename());

        // save the file
        Files.copy(file.getInputStream(), targetLocation);
        final Gif gif = new Gif();
        gif.setUrl(targetLocation.toString());
        gif.setLegend(file.getOriginalFilename());
        gif.setUploadUser(userMapper.toEntity(userDto));
        gif.setUploadDate(LocalDate.now());

        return gifMapper.toDto(gifRepository.save(gif));
    }

    @Override
    public GifDto findGifById(Long id) {
        final Gif gif = gifRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gif not found"));
        return gifMapper.toDto(gif);
    }

    @Override
    public Boolean deleteGif(Long id) {
        try {
            final GifDto gifDto = findGifById(id);
            gifRepository.deleteById(gifDto.getId());
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    @Override
    public Boolean addGifToDay(final GifDto gifDto, final Long dayId, final Long userId) {
        final DayDto dayDto = dayService.findDayById(dayId);
        final UserDto userDto = userService.findUserById(userId);

        if (userDto.getTokenBalance() < dayDto.getCost()) {
            throw new IllegalArgumentException("User does not have enough tokens to buy this gif");
        }

        // Add the user to the gif
        gifDto.setUploadUser(userDto);

        // Add gif to day
        dayDto.setGif(gifDto);

        // Update user token balance
        userDto.setTokenBalance(userDto.getTokenBalance() - dayDto.getCost());

        // Save updated day and user and gif
        return this.saveGif(gifDto) != null && dayService.saveDay(dayDto) != null && userService.saveUser(userDto) != null ;
    }

    @Override
    public Boolean addGifFileToDay(Long userId, MultipartFile file, Long dayId) throws IOException {
        final DayDto dayDto = dayService.findDayById(dayId);
        final UserDto userDto = userService.findUserById(userId);

        if (userDto.getTokenBalance() < dayDto.getCost()) {
            throw new IllegalArgumentException("User does not have enough tokens to buy this gif");
        }


        // update user token balance
        userDto.setTokenBalance(userDto.getTokenBalance() - dayDto.getCost());

        // Add gif to day and save gif
        dayDto.setGif(this.saveGifFile(file, userDto));

        // Save updated day and user
        return dayService.saveDay(dayDto) != null && userService.saveUser(userDto) != null;
    }


}
