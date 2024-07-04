package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.Reaction;
import fr.esgi.calendrier.dto.ReactionDto;
import fr.esgi.calendrier.mappers.ReactionMapper;
import fr.esgi.calendrier.repository.ReactionRepository;
import fr.esgi.calendrier.service.ReactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Reaction service.
 */
@Service
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;
    private final ReactionMapper reactionMapper;

    /**
     * Instantiates a new Reaction service.
     *
     * @param reactionRepository the reaction repository
     * @param reactionMapper     the reaction mapper
     */
    @Autowired
    public ReactionServiceImpl(final ReactionRepository reactionRepository, final ReactionMapper reactionMapper) {
        this.reactionRepository = reactionRepository;
        this.reactionMapper = reactionMapper;
    }

    @Override
    public ReactionDto saveReaction(ReactionDto reactionDto) {
        final Reaction reaction = reactionMapper.toEntity(reactionDto);
        return reactionMapper.toDto(reactionRepository.save(reaction));
    }

    @Override
    public ReactionDto getReactionById(Long id) {
        final Reaction reaction = reactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reaction not found with id: " + id));
        return reactionMapper.toDto(reaction);
    }

    @Override
    public List<ReactionDto> getAllReactions() {
        final List<Reaction> reactions = reactionRepository.findAll();
        return reactionMapper.toDtoList(reactions);
    }
}
