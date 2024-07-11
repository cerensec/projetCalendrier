package fr.esgi.calendrier;

import fr.esgi.calendrier.business.Gif;
import fr.esgi.calendrier.business.Theme;
import fr.esgi.calendrier.business.User;
import fr.esgi.calendrier.dto.GifDto;
import fr.esgi.calendrier.dto.ThemeDto;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.mappers.GifMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class GifMapperTest {

    private final GifMapper gifMapper;

    @Autowired
    public GifMapperTest(final GifMapper gifMapper) {
        this.gifMapper = gifMapper;
    }

    @Test
    void testToDto() {

        // Arrange
        final User user = User.builder()
                .id(1L)
                .firstName("Carlos")
                .lastName("Ceren")
                .email("email")
                .password("password")
                .tokenBalance(500)
                .theme(new Theme(1L,"Dark"))
                .build();
        final Gif gif = Gif.builder()
                .id(1L)
                .url("url")
                .legend("legend")
                .uploadDate(LocalDate.now())
                .uploadUser(user)
                .build();

        // Act
        final GifDto result = gifMapper.toDto(gif);

        // Assertions
        Assertions.assertEquals(gif.getId(), result.getId());
        Assertions.assertEquals(gif.getUrl(), result.getUrl());
        Assertions.assertEquals(gif.getLegend(), result.getLegend());
        Assertions.assertEquals(gif.getUploadDate(), result.getUploadDate());
        Assertions.assertEquals(gif.getUploadUser().getId(), result.getUploadUser().getId());
        Assertions.assertEquals(gif.getUploadUser().getFirstName(), result.getUploadUser().getFirstName());
        Assertions.assertEquals(gif.getUploadUser().getLastName(), result.getUploadUser().getLastName());
        Assertions.assertEquals(gif.getUploadUser().getEmail(), result.getUploadUser().getEmail());
    }

    void testToEntity() {
        // Arrange
        final UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("Carlos")
                .lastName("Ceren")
                .email("email")
                .password("password")
                .tokenBalance(500)
                .theme(ThemeDto.builder().id(1L).name("Dark").build())
                .build();
        final GifDto gifDto = GifDto.builder()
                .id(1L)
                .url("url")
                .legend("legend")
                .uploadDate(LocalDate.now())
                .uploadUser(userDto)
                .build();

        // Act
        final Gif result = gifMapper.toEntity(gifDto);

        // Assertions
        Assertions.assertEquals(gifDto.getId(), result.getId());
        Assertions.assertEquals(gifDto.getUrl(), result.getUrl());
        Assertions.assertEquals(gifDto.getLegend(), result.getLegend());
        Assertions.assertEquals(gifDto.getUploadDate(), result.getUploadDate());
        Assertions.assertEquals(gifDto.getUploadUser().getId(), result.getUploadUser().getId());
        Assertions.assertEquals(gifDto.getUploadUser().getFirstName(), result.getUploadUser().getFirstName());
        Assertions.assertEquals(gifDto.getUploadUser().getLastName(), result.getUploadUser().getLastName());
        Assertions.assertEquals(gifDto.getUploadUser().getEmail(), result.getUploadUser().getEmail());
    }
}
