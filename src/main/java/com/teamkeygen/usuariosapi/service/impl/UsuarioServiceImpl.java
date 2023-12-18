package com.teamkeygen.usuariosapi.service.impl;

import com.teamkeygen.usuariosapi.config.JwtTokenUtil;
import com.teamkeygen.usuariosapi.exception.UsuarioNoEncontradoException;
import com.teamkeygen.usuariosapi.exception.UsuarioYaRegistradoException;
import com.teamkeygen.usuariosapi.model.Telefono;
import com.teamkeygen.usuariosapi.model.Usuario;
import com.teamkeygen.usuariosapi.model.UsuarioResponse;
import com.teamkeygen.usuariosapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.teamkeygen.usuariosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${usuario.password.regex}")
    private String passwordRegex;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public UsuarioResponse crearUsuario(Usuario usuario) {
        // Validar la contraseña
        if (!Pattern.matches(passwordRegex, usuario.getContraseña())) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad.");
        }

        //Validar si ya existe el correo
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new UsuarioYaRegistradoException("El correo ya está registrado");
        }

        // Validar que al menos un teléfono sea proporcionado
        if (usuario.getTelefonos() == null || usuario.getTelefonos().isEmpty()) {
            throw new IllegalArgumentException("Debe proporcionar al menos un teléfono.");
        }

        String token = jwtTokenUtil.generateToken(usuario.getCorreo());
        usuario.setToken(token);

        // Asignar el usuario a cada teléfono y guardarlos
        usuario.getTelefonos().forEach(telefono -> telefono.setUsuario(usuario));

        // Guardar el usuario en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Crear y devolver un UsuarioResponse con la información relevante
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuarioGuardado.getId());
        usuarioResponse.setCreado(usuarioGuardado.getCreado().toString());
        usuarioResponse.setModificado(usuarioGuardado.getModificado().toString());
        usuarioResponse.setUltimoLogin(usuarioGuardado.getUltimoLogin().toString());
        usuarioResponse.setActivo(usuarioGuardado.isActivo());
        usuarioResponse.setToken(usuarioGuardado.getToken());

        return usuarioResponse;
    }



    // Obtener un usuario por su ID
    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Obtener todos los usuarios
    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }


    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        usuarioExistente.setContraseña(usuarioActualizado.getContraseña());

        usuarioExistente.getTelefonos().clear();
        for (Telefono telefono : usuarioActualizado.getTelefonos()) {
            telefono.setUsuario(usuarioExistente);
            usuarioExistente.getTelefonos().add(telefono);
        }

        return usuarioRepository.save(usuarioExistente);
    }




    // Eliminación lógica de un usuario
    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
}
