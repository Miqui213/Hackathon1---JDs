package com.example.hack1.application;

import com.example.hack1.domain.RestriccionModelo;
import com.example.hack1.service.RestriccionModeloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/restrictions")
public class RestriccionController {

    private final RestriccionModeloService restriccionService;

    public RestriccionController(RestriccionModeloService restriccionService) {
        this.restriccionService = restriccionService;
    }

    @PostMapping
    public ResponseEntity<RestriccionModelo> crearRestriccion(@RequestBody RestriccionModelo restriccion) {
        return ResponseEntity.ok(restriccionService.crearRestriccion(restriccion));
    }

    @GetMapping
    public ResponseEntity<List<RestriccionModelo>> listar(@RequestParam Long empresaId) {
        return ResponseEntity.ok(restriccionService.listarPorEmpresa(empresaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestriccionModelo> actualizar(@PathVariable Long id, @RequestBody RestriccionModelo r) {
        return ResponseEntity.ok(restriccionService.actualizarRestriccion(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        restriccionService.eliminarRestriccion(id);
        return ResponseEntity.noContent().build();
    }
}

