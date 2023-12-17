package com.teamkeygen.usuariosapi.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(Long id) {
        super("No se pudo encontrar el usuario con ID: " + id);
    }
}
