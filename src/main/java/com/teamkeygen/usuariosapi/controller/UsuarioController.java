package com.teamkeygen.usuariosapi.controller;

import com.teamkeygen.usuariosapi.exception.UsuarioYaRegistradoException;
import com.teamkeygen.usuariosapi.model.Usuario;
import com.teamkeygen.usuariosapi.model.UsuarioResponse;
import com.teamkeygen.usuariosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.teamkeygen.usuariosapi.exception.UsuarioNoEncontradoException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/insertarUsuario")
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody Usuario usuario) {
        UsuarioResponse nuevoUsuarioResponse = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuarioResponse);
    }

    @GetMapping("/consultarUsuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/consultarTodosLosUsuarios")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PutMapping("/actualizarUsuario/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            usuarioService.actualizarUsuario(id, usuario);
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Usuario actualizado correctamente");
            return ResponseEntity.ok(response);
        } catch (UsuarioNoEncontradoException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "No existe este usuario");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException | UsuarioYaRegistradoException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario desactivado correctamente");
        return ResponseEntity.ok(response);
    }
}
