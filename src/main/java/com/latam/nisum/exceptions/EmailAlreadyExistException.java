package com.latam.nisum.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailAlreadyExistException extends Exception{

    private final String message;
}
