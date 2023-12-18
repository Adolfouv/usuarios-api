package com.teamkeygen.usuariosapi.service;

import com.teamkeygen.usuariosapi.model.Usuario;
import com.teamkeygen.usuariosapi.model.UsuarioResponse;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    UsuarioResponse crearUsuario(Usuario usuario);

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    List<Usuario> obtenerTodosLosUsuarios();

    void actualizarUsuario(Long id, Usuario usuario);

    void eliminarUsuario(Long id);
}
