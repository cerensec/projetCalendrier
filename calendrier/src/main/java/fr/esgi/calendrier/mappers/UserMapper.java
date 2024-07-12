package fr.esgi.calendrier.mappers;

import fr.esgi.calendrier.business.Theme;
import fr.esgi.calendrier.business.User;
import fr.esgi.calendrier.dto.ThemeDto;
import fr.esgi.calendrier.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
public class UserMapper {

    /**
     * To dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .theme(themeToDto(user.getTheme()))
                .tokenBalance(user.getTokenBalance() == null ? 500 : user.getTokenBalance())
                .build();
    }

    /**
     * To entity user.
     *
     * @param userDto the user dto
     * @return the user
     */
    public User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .theme(themeToEntity(userDto.getTheme()))
                .tokenBalance(userDto.getTokenBalance() == null ? 500 : userDto.getTokenBalance())
                .build();
    }

    /**
     * Theme to dto theme dto.
     *
     * @param theme the theme
     * @return the theme dto
     */
    public ThemeDto themeToDto(Theme theme) {
        return ThemeDto.builder()
                .id(theme.getId())
                .name(theme.getName())
                .build();
    }

    /**
     * Theme to entity theme.
     *
     * @param themeDto the theme dto
     * @return the theme
     */
    public Theme themeToEntity(ThemeDto themeDto) {
        return Theme.builder()
                .id(themeDto.getId())
                .name(themeDto.getName())
                .build();
    }
}
