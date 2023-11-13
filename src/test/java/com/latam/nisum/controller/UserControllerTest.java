package com.latam.nisum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.latam.nisum.dto.UserRequestDTO;
import com.latam.nisum.dto.UserResponseDTO;
import com.latam.nisum.model.Phone;
import com.latam.nisum.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void testRegisterUser() throws Exception {
        Phone phone = new Phone();
        phone.setNumber(1L);
        phone.setCityCode(1);
        phone.setCountryCode(1);
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        UserRequestDTO requestDTO = new UserRequestDTO("name", "jesuslinares307@gmail.com", "Password1234", phones);

        UserResponseDTO mockResponse = new UserResponseDTO(UUID.randomUUID(), LocalDate.now(), LocalDate.now(), true, "token");

        when(userService.registerUser(any(UserRequestDTO.class))).thenReturn(mockResponse);

        mockMvc.perform(post("/api/v1/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        //assertEquals(requestDTO, any(UserRequestDTO.class));
        verify(userService, times(1)).registerUser(any(UserRequestDTO.class));
        verifyNoMoreInteractions(userService);
    }
}