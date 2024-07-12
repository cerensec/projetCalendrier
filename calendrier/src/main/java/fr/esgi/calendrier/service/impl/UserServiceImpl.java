package fr.esgi.calendrier.service.impl;

import fr.esgi.calendrier.business.User;
import fr.esgi.calendrier.dto.UserDto;
import fr.esgi.calendrier.mappers.UserMapper;
import fr.esgi.calendrier.repository.UserRepository;
import fr.esgi.calendrier.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(UserDto user) {
        final User userEntity = userMapper.toEntity(user);
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
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

        final String encryptedPassword = user.getPassword();
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        if (!passwordEncoder.matches(password, encryptedPassword)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }
}
