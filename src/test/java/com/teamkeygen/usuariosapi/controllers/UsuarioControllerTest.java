package com.teamkeygen.usuariosapi.controllers;

import com.teamkeygen.usuariosapi.controller.UsuarioController;
import com.teamkeygen.usuariosapi.model.Telefono;
import com.teamkeygen.usuariosapi.model.Usuario;
import com.teamkeygen.usuariosapi.model.UsuarioResponse;
import com.teamkeygen.usuariosapi.service.UsuarioService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doNothing;


@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    UsuarioService usuarioService;

    @Test
    public void crearUsuarioTest() {
        MockitoAnnotations.initMocks(this);

        Telefono telefono = new Telefono();
        telefono.setNumero("22132141");
        telefono.setCodigoCiudad("7");
        telefono.setCodigoPais("56");

        Set<Telefono> telefonos = new HashSet<>();
        telefonos.add(telefono);

        Usuario usuario = new Usuario();
        usuario.setNombre("Adolfo Ulloa");
        usuario.setCorreo("fito8829@example.com");
        usuario.setContraseña("p2assWORD!");
        usuario.setTelefonos(telefonos);

        when(usuarioService.crearUsuario(any(Usuario.class))).thenReturn(new UsuarioResponse());

        usuarioController.crearUsuario(usuario);
    }

    @Test
    public void obtenerUsuarioPorIdTest() {
        MockitoAnnotations.initMocks(this);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan Perez");

        when(usuarioService.obtenerUsuarioPorId(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuario> response = usuarioController.obtenerUsuarioPorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Juan Perez", response.getBody().getNombre());
    }

    @Test
    public void obtenerTodosLosUsuariosTest() {
        MockitoAnnotations.initMocks(this);

        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());

        when(usuarioService.obtenerTodosLosUsuarios()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioController.obtenerTodosLosUsuarios();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    public void actualizarUsuarioTest() {
        MockitoAnnotations.initMocks(this);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan Actualizado");

        doNothing().when(usuarioService).actualizarUsuario(anyLong(), any(Usuario.class));

        usuarioController.actualizarUsuario(1L, usuario);
    }



    @Test
    public void eliminarUsuarioTest() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(usuarioService).eliminarUsuario(1L);

        usuarioController.eliminarUsuario(1L);
    }


}
