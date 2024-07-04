package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.Gif;
import fr.esgi.calendrier.dto.GifDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Gif mapper.
 */
@Component
public class GifMapper {

    private final UserMapper userMapper;

    /**
     * Instantiates a new Gif mapper.
     *
     * @param userMapper     the user mapper
     * @param reactionMapper the reaction mapper
     */
    @Autowired
    public GifMapper(final UserMapper userMapper, final ReactionMapper reactionMapper) {
        this.userMapper = userMapper;
    }

    /**
     * To dto gif dto.
     *
     * @param gif the gif
     * @return the gif dto
     */
    public GifDto toDto(final Gif gif) {
        return GifDto.builder()
                .id(gif.getId())
                .url(gif.getUrl())
                .legend(gif.getLegend())
                .uploadDate(gif.getUploadDate())
                .cost(gif.getCost())
                .uploadUser(userMapper.toDto(gif.getUploadUser()))
                .build();

    }

    /**
     * To entity gif.
     *
     * @param gifDto the gif dto
     * @return the gif
     */
    public Gif toEntity(final GifDto gifDto) {
        return Gif.builder()
                .id(gifDto.getId())
                .url(gifDto.getUrl())
                .legend(gifDto.getLegend())
                .uploadDate(gifDto.getUploadDate())
                .cost(gifDto.getCost())
                .uploadUser(userMapper.toEntity(gifDto.getUploadUser()))
                .build();
    }
}
