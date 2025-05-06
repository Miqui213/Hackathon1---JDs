package com.example.hack1.infraestructure;

import com.example.hack1.domain.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByUsuarioIdOrderByFechaHoraDesc(Long usuarioId);
    List<Solicitud> findByTipoModelo(String tipoModelo);
}

