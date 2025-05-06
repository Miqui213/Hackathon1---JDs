package com.example.hack1.application;

import com.example.hack1.domain.LimiteUsuario;
import com.example.hack1.domain.Usuario;
import com.example.hack1.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/company/users")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(@RequestParam Long empresaId) {
        return ResponseEntity.ok(usuarioService.listarUsuariosPorEmpresa(empresaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario u) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, u));
    }

    @PostMapping("/{id}/limits")
    public ResponseEntity<LimiteUsuario> asignarLimite(@PathVariable Long id, @RequestBody LimiteUsuario limite) {
        return ResponseEntity.ok(usuarioService.asignarLimite(id, limite));
    }

    @GetMapping("/{id}/consumption")
    public ResponseEntity<Map<String, Object>> obtenerConsumo(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerConsumoUsuario(id));
    }
}
