package com.latam.nisum.controller;

import com.latam.nisum.dto.UserRequestDTO;
import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.exceptions.EmailAlreadyExistException;
import com.latam.nisum.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) throws EmailAlreadyExistException {
        log.info("register an user from controller to services");
        UserResponseDTO responseDTO = userService.registerUser(userRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
