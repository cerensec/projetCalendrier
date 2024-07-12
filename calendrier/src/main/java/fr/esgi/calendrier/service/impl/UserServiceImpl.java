package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.User;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.mappers.UserMapper;
import fr.esgi.calendrier.repository.UserRepository;
import fr.esgi.calendrier.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     * @param userMapper     the user mapper
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto saveUser(UserDto user) {
        final User userEntity = userMapper.toEntity(user);
        return userMapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public UserDto findUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        final User user = userRepository.findByEmailIgnoreCase(email).orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto login(String email, String password) {
        final UserDto user = findUserByEmail(email);

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }
}
