package com.example.hack1.service;

import com.example.hack1.domain.Empresa;
import com.example.hack1.infraestructure.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa obtenerEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
    }

    public Empresa actualizarEmpresa(Long id, Empresa actualizada) {
        Empresa empresa = obtenerEmpresaPorId(id);
        empresa.setNombre(actualizada.getNombre());
        empresa.setRuc(actualizada.getRuc());
        empresa.setFechaAfiliacion(actualizada.getFechaAfiliacion());
        return empresaRepository.save(empresa);
    }

    public Empresa cambiarEstadoEmpresa(Long id, boolean activo) {
        Empresa empresa = obtenerEmpresaPorId(id);
        empresa.setEstadoActivo(activo);
        return empresaRepository.save(empresa);
    }

    // Este método simula el cálculo del consumo (lógica personalizada en siguiente iteración)
    public Map<String, Object> obtenerConsumo(Long empresaId) {
        // Placeholder
        return Map.of("modeloA", 1500, "modeloB", 3000);
    }
}

