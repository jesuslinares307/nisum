package com.latam.nisum.mapper;

import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<User, UserResponseDTO> {

    @Override
    public UserResponseDTO apply(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getCreated(),
                user.getLastLogin(),
                user.isActive(),
                user.getToken()
        );
    }

}
