package com.latam.nisum.service.impl;

import com.latam.nisum.dto.UserRequestDTO;
import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.mapper.UserDTOMapper;
import com.latam.nisum.model.Phone;
import com.latam.nisum.model.User;
import com.latam.nisum.repository.UserRepository;
import com.latam.nisum.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDTOMapper userDTOMapper;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void whenRegisterUserSuccess() throws Exception {
        Phone phone = new Phone();
        phone.setNumber(1L);
        phone.setCityCode(1);
        phone.setCountryCode(1);
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);

        UserRequestDTO userRequestDTO = new UserRequestDTO("name", "email", "password", phones);
        User user = new User();
        UserResponseDTO expectedResponse = new UserResponseDTO(UUID.randomUUID(), LocalDate.now(), LocalDate.now(), true, "token");

        when(userRepository.existsByEmail(userRequestDTO.email())).thenReturn(false);
        when(jwtUtil.generateToken(anyString())).thenReturn("token");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userDTOMapper.apply(user)).thenReturn(expectedResponse);

        UserResponseDTO actualResponse = userService.registerUser(userRequestDTO);

        assertEquals(expectedResponse, actualResponse);
        verify(userRepository, times(1)).existsByEmail(userRequestDTO.email());
        verify(jwtUtil, times(1)).generateToken(anyString());
        verify(userRepository, times(1)).save(any(User.class));
        verify(userDTOMapper, times(1)).apply(user);
    }

    @Test
    void whenRegisterUserWithEmailAlreadyRegistered() {
        Phone phone = new Phone();
        phone.setNumber(1L);
        phone.setCityCode(1);
        phone.setCountryCode(1);
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);


        UserRequestDTO userRequestDTO = new UserRequestDTO("name", "email", "password", phones);

        when(userRepository.existsByEmail(userRequestDTO.email())).thenReturn(true);


        assertThrows(Exception.class, () -> userService.registerUser(userRequestDTO));

        verify(userRepository, never()).save(any(User.class));
        verify(userDTOMapper, never()).apply(any(User.class));
    }

}