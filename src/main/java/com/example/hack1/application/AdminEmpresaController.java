package com.example.hack1.application;

import com.example.hack1.domain.Empresa;
import com.example.hack1.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/companies")
public class AdminEmpresaController {

    private final EmpresaService empresaService;

    public AdminEmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.crearEmpresa(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        return ResponseEntity.ok(empresaService.listarEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.obtenerEmpresaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.actualizarEmpresa(id, empresa));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Empresa> cambiarEstadoEmpresa(@PathVariable Long id, @RequestParam boolean activo) {
        return ResponseEntity.ok(empresaService.cambiarEstadoEmpresa(id, activo));
    }

    @GetMapping("/{id}/consumption")
    public ResponseEntity<Map<String, Object>> obtenerConsumoEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.obtenerConsumo(id));
    }
}

