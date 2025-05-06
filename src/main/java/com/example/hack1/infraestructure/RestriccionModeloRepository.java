package com.example.hack1.infraestructure;

import com.example.hack1.domain.RestriccionModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestriccionModeloRepository extends JpaRepository<RestriccionModelo, Long> {
    List<RestriccionModelo> findByEmpresaId(Long empresaId);
    List<RestriccionModelo> findByTipoModelo(String tipoModelo);
}

