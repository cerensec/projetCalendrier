package fr.esgi.calendrier.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * DTO for {@link fr.esgi.calendrier.business.User}
 */
@Data
@Builder
public class UserDto implements Serializable {
    Long id;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    String email;
    @Length(min = 3)
    String password;
    Integer tokenBalance;
    @NotNull
    ThemeDto theme;
}