package fr.esgi.calendrier.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = "^.+\\.(?i)(gif)$", message = "URL must end with .gif")
    private String url;

    @Column
    private String legend;

    @Column(nullable = false)
    private LocalDate uploadDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User uploadUser;

}
