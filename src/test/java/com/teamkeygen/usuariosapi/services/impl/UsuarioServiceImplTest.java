package com.teamkeygen.usuariosapi.services.impl;


import com.teamkeygen.usuariosapi.config.JwtTokenUtil;
import com.teamkeygen.usuariosapi.model.Usuario;
import com.teamkeygen.usuariosapi.repository.UsuarioRepository;
import com.teamkeygen.usuariosapi.service.impl.UsuarioServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.doAnswer;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private JwtTokenUtil jwtTokenUtil;



    @Test
    public void obtenerUsuarioPorIdTest() {
        MockitoAnnotations.initMocks(this);

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.obtenerUsuarioPorId(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId().longValue());
    }

    @Test
    public void obtenerTodosLosUsuariosTest() {
        MockitoAnnotations.initMocks(this);

        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.obtenerTodosLosUsuarios();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }




    @Test
    public void eliminarUsuarioTest() {
        MockitoAnnotations.initMocks(this);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setActivo(true);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        doAnswer(invocation -> {
            usuario.setActivo(false);
            return null;
        }).when(usuarioRepository).save(any(Usuario.class));

        usuarioService.eliminarUsuario(1L);

        assertFalse(usuario.isActivo());
    }


}
