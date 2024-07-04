package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.GifReactionDto;
import fr.esgi.calendrier.request.AddReactionToGifRequest;

import java.util.List;

/**
 * The interface Gif reaction service.
 */
public interface GifReactionService {

    /**
     * Save gif reaction gif reaction dto.
     *
     * @param request the request
     * @return the gif reaction dto
     */
    GifReactionDto saveGifReaction(final AddReactionToGifRequest request);

    /**
     * Find all gif reactions by gif id list.
     *
     * @param gifId the gif id
     * @return the list
     */
    List<GifReactionDto> findAllGifReactionsByGifId(final Long gifId);


}
