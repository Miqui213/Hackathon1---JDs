package com.example.hack1.infraestructure;

import com.example.hack1.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmpresaId(Long empresaId);
    Optional<Usuario> findByCorreo(String correo);
}
