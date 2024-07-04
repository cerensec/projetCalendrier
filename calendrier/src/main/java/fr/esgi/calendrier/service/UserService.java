package fr.esgi.calendrier.service;

import fr.esgi.calendrier.dto.UserDto;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user user dto.
     *
     * @param user the user
     * @return the user dto
     */
    UserDto saveUser(UserDto user);

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
}
