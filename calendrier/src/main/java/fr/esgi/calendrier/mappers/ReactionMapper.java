package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.Reaction;
import fr.esgi.calendrier.dto.ReactionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Reaction mapper.
 */
@Component
public class ReactionMapper {

    /**
     * To dto reaction dto.
     *
     * @param reaction the reaction
     * @return the reaction dto
     */
    public ReactionDto toDto(final Reaction reaction) {
        return ReactionDto.builder()
                .id(reaction.getId())
                .name(reaction.getName())
                .emoji(reaction.getEmoji())
                .build();

    }

    /**
     * To entity reaction.
     *
     * @param reactionDto the reaction dto
     * @return the reaction
     */
    public Reaction toEntity(final ReactionDto reactionDto) {
        return Reaction.builder()
                .id(reactionDto.getId())
                .name(reactionDto.getName())
                .emoji(reactionDto.getEmoji())
                .build();
    }

    /**
     * To dto list list.
     *
     * @param reactions the reactions
     * @return the list
     */
    public List<ReactionDto> toDtoList(final List<Reaction> reactions) {
        return reactions.stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     * To entity list list.
     *
     * @param reactionDtos the reaction dtos
     * @return the list
     */
    public List<Reaction> toEntityList(final List<ReactionDto> reactionDtos) {
        return reactionDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
