package fr.esgi.calendrier.repository;

import fr.esgi.calendrier.business.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}