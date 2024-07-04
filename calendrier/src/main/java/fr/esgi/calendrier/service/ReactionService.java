package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.ReactionDto;

import java.util.List;

/**
 * The interface Reaction service.
 */
public interface ReactionService {

    /**
     * Save reaction reaction dto.
     *
     * @param reactionDto the reaction dto
     * @return the reaction dto
     */
    ReactionDto saveReaction(ReactionDto reactionDto);

    /**
     * Gets reaction by id.
     *
     * @param id the id
     * @return the reaction by id
     */
    ReactionDto getReactionById(Long id);

    /**
     * Gets all reactions.
     *
     * @return the all reactions
     */
    List<ReactionDto> getAllReactions();

}
