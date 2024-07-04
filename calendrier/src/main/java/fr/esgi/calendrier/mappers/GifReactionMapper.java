package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.GifReaction;
import fr.esgi.calendrier.dto.GifReactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Gif reaction mapper.
 */
@Component
public class GifReactionMapper {

    private final GifMapper gifMapper;
    private final ReactionMapper reactionMapper;
    private final UserMapper userMapper;

    /**
     * Instantiates a new Gif reaction mapper.
     *
     * @param gifMapper      the gif mapper
     * @param reactionMapper the reaction mapper
     * @param userMapper     the user mapper
     */
    @Autowired
    public GifReactionMapper(final GifMapper gifMapper, final ReactionMapper reactionMapper, final UserMapper userMapper) {
        this.gifMapper = gifMapper;
        this.reactionMapper = reactionMapper;
        this.userMapper = userMapper;
    }

    /**
     * To dto gif reaction dto.
     *
     * @param gifReaction the gif reaction
     * @return the gif reaction dto
     */
    public GifReactionDto toDto(final GifReaction gifReaction) {
        return GifReactionDto.builder()
                .id(gifReaction.getId())
                .gif(gifMapper.toDto(gifReaction.getGif()))
                .user(userMapper.toDto(gifReaction.getUser()))
                .reaction(reactionMapper.toDto(gifReaction.getReaction()))
                .build();
    }

    /**
     * To entity gif reaction.
     *
     * @param gifReactionDto the gif reaction dto
     * @return the gif reaction
     */
    public GifReaction toEntity(final GifReactionDto gifReactionDto) {
        return GifReaction.builder()
                .id(gifReactionDto.getId())
                .gif(gifMapper.toEntity(gifReactionDto.getGif()))
                .user(userMapper.toEntity(gifReactionDto.getUser()))
                .reaction(reactionMapper.toEntity(gifReactionDto.getReaction()))
                .build();
    }

    /**
     * To dto list list.
     *
     * @param gifReactions the gif reactions
     * @return the list
     */
    public List<GifReactionDto> toDtoList(final List<GifReaction> gifReactions) {
        return gifReactions.stream().map(this::toDto).toList();
    }

    /**
     * To entity list list.
     *
     * @param gifReactionDtos the gif reaction dtos
     * @return the list
     */
    public List<GifReaction> toEntityList(final List<GifReactionDto> gifReactionDtos) {
        return gifReactionDtos.stream().map(this::toEntity).toList();
    }

}
