package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.GifReaction;
import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.dto.GifReactionDto;
import fr.esgi.calendrier.dto.ReactionDto;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.mappers.GifReactionMapper;
import fr.esgi.calendrier.repository.GifReactionRepository;
import fr.esgi.calendrier.request.AddReactionToGifRequest;
import fr.esgi.calendrier.service.GifReactionService;
import fr.esgi.calendrier.service.GifService;
import fr.esgi.calendrier.service.ReactionService;
import fr.esgi.calendrier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Gif reaction service.
 */
@Service
public class GifReactionServiceImpl implements GifReactionService {

    private final GifReactionRepository gifReactionRepository;
    private final GifReactionMapper gifReactionMapper;
    private final ReactionService reactionService;
    private final GifService gifService;
    private final UserService userService;

    /**
     * Instantiates a new Gif reaction service.
     *
     * @param gifReactionRepository the gif reaction repository
     * @param gifReactionMapper     the gif reaction mapper
     */
    @Autowired
    public GifReactionServiceImpl(final GifReactionRepository gifReactionRepository, final GifReactionMapper gifReactionMapper,
                                  final ReactionService reactionService, final GifService gifService, final UserService userService) {
        this.gifReactionRepository = gifReactionRepository;
        this.gifReactionMapper = gifReactionMapper;
        this.reactionService = reactionService;
        this.gifService = gifService;
        this.userService = userService;
    }

    @Override
    public GifReactionDto saveGifReaction(final AddReactionToGifRequest request) {
        final ReactionDto reactionDto = reactionService.getReactionById(request.getReactionId());
        final GifDto gifDto = gifService.findGifById(request.getGifId());
        final UserDto userDto = userService.findUserById(request.getUserId());

        final GifReactionDto gifReactionDto = GifReactionDto.builder()
                .gif(gifDto)
                .user(userDto)
                .reaction(reactionDto)
                .build();

        final GifReaction gifReaction = gifReactionMapper.toEntity(gifReactionDto);

        return  gifReactionMapper.toDto(gifReactionRepository.save(gifReaction));
    }

    @Override
    public List<GifReactionDto> findAllGifReactionsByGifId(final Long gifId) {
        final List<GifReaction> reactions = gifReactionRepository.findByGif_Id(gifId);
        return gifReactionMapper.toDtoList(reactions);
    }
}
