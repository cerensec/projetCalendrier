package fr.esgi.calendrier.repository;

import fr.esgi.calendrier.business.GifReaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GifReactionRepository extends JpaRepository<GifReaction, Long> {
    List<GifReaction> findByGif_Id(Long id);
}