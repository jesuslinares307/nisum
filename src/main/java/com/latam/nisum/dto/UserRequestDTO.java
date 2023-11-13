package com.latam.nisum.dto;

import com.latam.nisum.model.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record UserRequestDTO(
        String name,

        @NotEmpty(message = "El correo no puede estar vacío")
        @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Formato de correo no válido")
        String email,

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "La contraseña no cumple con el formato requerido")
        String password,
        List<Phone> phones
) {
}
