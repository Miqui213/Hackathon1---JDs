package com.example.hack1.service;

import com.example.hack1.domain.Solicitud;
import com.example.hack1.infraestructure.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IAService {

    private final SolicitudRepository solicitudRepository;

    public IAService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public Solicitud procesarConsulta(Solicitud solicitud) {
        solicitud.setFechaHora(LocalDateTime.now());
        // Aquí podrías simular el procesamiento o llamar una API externa
        // solicitud.setRespuesta("Simulación de respuesta");
        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> obtenerHistorial(Long usuarioId) {
        return solicitudRepository.findByUsuarioIdOrderByFechaHoraDesc(usuarioId);
    }

    public List<String> obtenerModelosDisponibles(Long usuarioId) {
        // Esto se puede basar en restricciones, límites, permisos, etc.
        return List.of("gpt-4", "gpt-3.5", "dalle-3");
    }
}

