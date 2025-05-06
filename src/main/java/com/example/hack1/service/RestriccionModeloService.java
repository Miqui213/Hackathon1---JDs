package com.example.hack1.service;

import com.example.hack1.domain.RestriccionModelo;
import com.example.hack1.infraestructure.RestriccionModeloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestriccionModeloService {

    private final RestriccionModeloRepository restriccionRepo;

    public RestriccionModeloService(RestriccionModeloRepository restriccionRepo) {
        this.restriccionRepo = restriccionRepo;
    }

    public RestriccionModelo crearRestriccion(RestriccionModelo restriccion) {
        return restriccionRepo.save(restriccion);
    }

    public List<RestriccionModelo> listarPorEmpresa(Long empresaId) {
        return restriccionRepo.findByEmpresaId(empresaId);
    }

    public RestriccionModelo actualizarRestriccion(Long id, RestriccionModelo actualizada) {
        RestriccionModelo existente = restriccionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restricción no encontrada"));

        existente.setTipoModelo(actualizada.getTipoModelo());
        existente.setLimiteMensualTokens(actualizada.getLimiteMensualTokens());
        existente.setLimiteDiarioSolicitudes(actualizada.getLimiteDiarioSolicitudes());

        return restriccionRepo.save(existente);
    }

    public void eliminarRestriccion(Long id) {
        restriccionRepo.deleteById(id);
    }
}

