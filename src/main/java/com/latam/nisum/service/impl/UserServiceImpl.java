package com.latam.nisum.service.impl;

import com.latam.nisum.dto.UserRequestDTO;
import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.exceptions.EmailAlreadyExistException;
import com.latam.nisum.mapper.UserDTOMapper;
import com.latam.nisum.model.User;
import com.latam.nisum.repository.UserRepository;
import com.latam.nisum.service.UserService;
import com.latam.nisum.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
@Builder
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final JwtUtil jwtUtil;

    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) throws EmailAlreadyExistException {
        log.info("Check if the email is already registered");
        if (userRepository.existsByEmail(userRequestDTO.email())) {
            throw new EmailAlreadyExistException("El correo ya esta registrado");
        }
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .password(userRequestDTO.password())
                .phones(userRequestDTO.phones())
                .created(LocalDate.now())
                .modified(LocalDate.now())
                .lastLogin(LocalDate.now())
                .token(jwtUtil.generateToken(userRequestDTO.email()))
                .isActive(true)
                .build();

        log.info("register an user from services to repository");
        User userResponse = userRepository.save(user);
        return userDTOMapper.apply(userResponse);

    }
}
