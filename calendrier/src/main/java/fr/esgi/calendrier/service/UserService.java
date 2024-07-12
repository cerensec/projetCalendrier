package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.request.SaveUserRequest;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user user dto.
     *
     * @param request the request
     * @return the user dto
     */
    UserDto saveUser(SaveUserRequest request);

    /**
     * Update user user dto.
     *
     * @param userDto the user dto
     * @return the user dto
     */
    UserDto updateUser(UserDto userDto);

    /**
     * Find user by id user dto.
     *
     * @param id the id
     * @return the user dto
     */
    UserDto findUserById(Long id);

    /**
     * Find user by email user dto.
     *
     * @param email the email
     * @return the user dto
     */
    UserDto findUserByEmail(String email);

    /**
     * Login user dto.
     *
     * @param email    the email
     * @param password the password
     * @return the user dto
     */
    UserDto login(String email, String password);
}
