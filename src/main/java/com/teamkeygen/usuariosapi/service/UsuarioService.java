package com.teamkeygen.usuariosapi.service;

import com.teamkeygen.usuariosapi.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    List<Usuario> obtenerTodosLosUsuarios();

    Usuario actualizarUsuario(Long id, Usuario usuario);

    void eliminarUsuario(Long id);
}