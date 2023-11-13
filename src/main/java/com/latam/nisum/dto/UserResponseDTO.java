package com.latam.nisum.dto;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponseDTO(UUID id,
                              LocalDate created,
                              LocalDate lastLogin,
                              boolean isActive,
                              String token
) {
}
