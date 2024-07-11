package fr.esgi.calendrier;

import fr.esgi.calendrier.controller.GifReactionController;
import fr.esgi.calendrier.dto.*;
import fr.esgi.calendrier.request.AddReactionToGifRequest;
import fr.esgi.calendrier.service.GifReactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class GifReactionControllerTest {

    @Mock
    private GifReactionService gifReactionService;

    @Test
    void testAddReactionToGif() {
        // Arrange
        final GifReactionController controller = new GifReactionController(gifReactionService);
        Mockito.when(gifReactionService.saveGifReaction(Mockito.any()))
                .thenReturn(responseBuilder());
        final AddReactionToGifRequest request = new AddReactionToGifRequest();
        request.setReactionId(1L);
        request.setGifId(1L);
        request.setUserId(1L);

        // Act
        final ResponseEntity<GifReactionDto> response = controller.save(request);

        // Assertions
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals(1L, response.getBody().getGif().getId());
        Assertions.assertEquals(1L, response.getBody().getUser().getId());
        Assertions.assertEquals(1L, response.getBody().getReaction().getId());
        Assertions.assertEquals("Carlos", response.getBody().getUser().getFirstName());
        Assertions.assertEquals("Ceren", response.getBody().getUser().getLastName());
        Assertions.assertEquals("legend", response.getBody().getGif().getLegend());
    }

    @Test
    void testGetReactionsByGifId() {
        // Arrange
        final GifReactionController controller = new GifReactionController(gifReactionService);
        Mockito.when(gifReactionService.findAllGifReactionsByGifId(Mockito.any()))
                .thenReturn(gifReactionDtoListBuilder());
        final Long gifId = 1L;

        // Act
        final ResponseEntity<List<GifReactionDto>> response = controller.getAllByGifId(gifId);

        // Assertions
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertEquals(3, response.getBody().size());
        Assertions.assertEquals(1L, response.getBody().get(0).getGif().getId());
        Assertions.assertEquals(1L, response.getBody().get(1).getGif().getId());
        Assertions.assertEquals(1L, response.getBody().get(2).getGif().getId());
        Assertions.assertEquals("smile", response.getBody().get(0).getReaction().getName());
        Assertions.assertEquals("sad", response.getBody().get(1).getReaction().getName());
        Assertions.assertEquals("heart", response.getBody().get(2).getReaction().getName());
    }


    private GifReactionDto responseBuilder() {
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
                .cost(30)
                .uploadUser(userDto)
                .build();
        final ReactionDto reactionDto = ReactionDto.builder()
                .id(1L)
                .name("smile")
                .emoji("U+1F642")
                .build();

        return GifReactionDto.builder()
                .gif(gifDto)
                .user(userDto)
                .reaction(reactionDto)
                .build();
    }

    private List<GifReactionDto> gifReactionDtoListBuilder() {
        final GifReactionDto smile = responseBuilder();
        final GifReactionDto sad = responseBuilder();
        sad.getReaction().setId(2L);
        sad.getReaction().setName("sad");
        sad.getReaction().setEmoji("U+1F622");
        final GifReactionDto heart = responseBuilder();
        heart.getReaction().setId(3L);
        heart.getReaction().setName("heart");
        heart.getReaction().setEmoji("U+2764");

        return List.of(smile, sad, heart);

    }

}
