package com.teamkeygen.usuariosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.*;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", "Los parámetros ingresados no son los correctos. Por favor, introduzca un objeto válido.");
        response.put("ejemplo para invocar este endpoint", ejemploJson());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> ejemploJson() {
        Map<String, Object> ejemplo = new LinkedHashMap<>();
        ejemplo.put("nombre", "Juan Rodriguez");
        ejemplo.put("correo", "juan@rodriguez.org");
        ejemplo.put("contraseña", "p2assWORD!");

        List<Map<String, String>> telefonos = new ArrayList<>();
        Map<String, String> telefono = new HashMap<>();
        telefono.put("numero", "1234567");
        telefono.put("codigoCiudad", "1");
        telefono.put("codigoPais", "57");
        telefonos.add(telefono);

        ejemplo.put("telefonos", telefonos);

        return ejemplo;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

