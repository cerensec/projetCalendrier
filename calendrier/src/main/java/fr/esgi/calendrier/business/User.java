package fr.esgi.calendrier.business;

import fr.esgi.calendrier.validation.EsgiEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    @EsgiEmail
    private String email;

    @Column(nullable = false)
    @Length(min = 3)
    private String password;

    @Column
    private Integer tokenBalance = 500;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;


}
