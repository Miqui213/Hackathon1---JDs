package com.example.hack1.infraestructure;

import com.example.hack1.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByRuc(String ruc);
    List<Empresa> findByEstadoActivo(boolean estadoActivo);
}

