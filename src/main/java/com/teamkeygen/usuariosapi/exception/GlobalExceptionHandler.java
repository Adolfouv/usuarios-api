package com.teamkeygen.usuariosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioYaRegistradoException.class)
    public ResponseEntity<?> handleUsuarioYaRegistradoException(UsuarioYaRegistradoException e) {
        Map<String, String> error = new HashMap<>();
        error.put("mensaje", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
