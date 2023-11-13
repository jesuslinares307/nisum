package com.latam.nisum.service;

import com.latam.nisum.dto.UserRequestDTO;
import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.exceptions.EmailAlreadyExistException;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO) throws EmailAlreadyExistException;
}
