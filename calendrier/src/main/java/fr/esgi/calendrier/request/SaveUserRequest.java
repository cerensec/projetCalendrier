package fr.esgi.calendrier.request;

import lombok.Data;

@Data
public class SaveUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long themeId;
}
