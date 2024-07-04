package fr.esgi.calendrier.repository;

import fr.esgi.calendrier.business.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}