package fr.esgi.calendrier;

import fr.esgi.calendrier.business.Day;
import fr.esgi.calendrier.business.Reaction;
import fr.esgi.calendrier.business.Theme;
import fr.esgi.calendrier.repository.DayRepository;
import fr.esgi.calendrier.repository.ReactionRepository;
import fr.esgi.calendrier.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
public class DataInit implements CommandLineRunner {

    private final ThemeRepository themeRepository;
    private final ReactionRepository reactionRepository;
    private final DayRepository dayRepository;

    @Autowired
    public DataInit(final ThemeRepository themeRepository, final ReactionRepository reactionRepository, final DayRepository dayRepository) {
        this.themeRepository = themeRepository;
        this.reactionRepository = reactionRepository;
        this.dayRepository = dayRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        // Theme init
        final Theme lightTheme = new Theme();
        lightTheme.setName("Light");
        final Theme darkTheme = new Theme();
        darkTheme.setName("Dark");
        themeRepository.saveAll(List.of(lightTheme, darkTheme));

        // Reaction init
        final Reaction smile = new Reaction();
        smile.setName("Smile");
        smile.setEmoji("U+1F642");
        final Reaction laugh = new Reaction();
        laugh.setName("Laugh");
        laugh.setEmoji("U+1F602");
        final Reaction love = new Reaction();
        love.setName("Love");
        love.setEmoji("U+1F60D");
        final Reaction sad = new Reaction();
        sad.setName("Sad");
        sad.setEmoji("U+1F622");
        final Reaction angry = new Reaction();
        angry.setName("Angry");
        angry.setEmoji("U+1F621");
        reactionRepository.saveAll(List.of(smile, laugh, love, sad, angry));

        // Day init
        final LocalDate now = LocalDate.now();
        final int monthDays = now.lengthOfMonth();
        final Random random = new Random();

        for (int i = 1; i <= monthDays; i++) {
            LocalDate date = LocalDate.of(now.getYear(), now.getMonth(), i);
            Day day = new Day();
            day.setDate(date);
            day.setCost(random.nextInt((50-10) +1 ) + 10);
            dayRepository.save(day);
        }
    }
}
