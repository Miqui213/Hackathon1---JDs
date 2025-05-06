package com.example.hack1.infraestructure;

import com.example.hack1.domain.LimiteUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimiteUsuarioRepository extends JpaRepository<LimiteUsuario, Long> {
    List<LimiteUsuario> findByUsuarioId(Long usuarioId);
    List<LimiteUsuario> findByTipoModeloAndUsuarioId(String tipoModelo, Long usuarioId);
}

