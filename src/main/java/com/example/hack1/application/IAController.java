package com.example.hack1.application;

import com.example.hack1.domain.Solicitud;
import com.example.hack1.service.IAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
public class IAController {

    private final IAService iaService;

    public IAController(IAService iaService) {
        this.iaService = iaService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Solicitud> consultaChat(@RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(iaService.procesarConsulta(solicitud));
    }

    @PostMapping("/completion")
    public ResponseEntity<Solicitud> consultaCompletion(@RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(iaService.procesarConsulta(solicitud));
    }

    @PostMapping("/multimodal")
    public ResponseEntity<Solicitud> consultaMultimodal(@RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(iaService.procesarConsulta(solicitud));
    }

    @GetMapping("/models")
    public ResponseEntity<List<String>> obtenerModelos(@RequestParam Long usuarioId) {
        return ResponseEntity.ok(iaService.obtenerModelosDisponibles(usuarioId));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Solicitud>> historial(@RequestParam Long usuarioId) {
        return ResponseEntity.ok(iaService.obtenerHistorial(usuarioId));
    }
}

