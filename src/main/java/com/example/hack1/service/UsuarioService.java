package com.example.hack1.service;

import com.example.hack1.domain.LimiteUsuario;
import com.example.hack1.domain.Solicitud;
import com.example.hack1.domain.Usuario;
import com.example.hack1.infraestructure.LimiteUsuarioRepository;
import com.example.hack1.infraestructure.SolicitudRepository;
import com.example.hack1.infraestructure.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LimiteUsuarioRepository limiteRepo;
    private final SolicitudRepository solicitudRepo;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          LimiteUsuarioRepository limiteRepo,
                          SolicitudRepository solicitudRepo) {
        this.usuarioRepository = usuarioRepository;
        this.limiteRepo = limiteRepo;
        this.solicitudRepo = solicitudRepo;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuariosPorEmpresa(Long empresaId) {
        return usuarioRepository.findByEmpresaId(empresaId);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
    }

    public Usuario actualizarUsuario(Long id, Usuario actualizado) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setNombre(actualizado.getNombre());
        usuario.setCorreo(actualizado.getCorreo());
        usuario.setRol(actualizado.getRol());
        return usuarioRepository.save(usuario);
    }

    public LimiteUsuario asignarLimite(Long usuarioId, LimiteUsuario limite) {
        Usuario usuario = obtenerUsuarioPorId(usuarioId);
        limite.setUsuario(usuario);
        return limiteRepo.save(limite);
    }

    public Map<String, Object> obtenerConsumoUsuario(Long usuarioId) {
        List<Solicitud> solicitudes = solicitudRepo.findByUsuarioIdOrderByFechaHoraDesc(usuarioId);
        int totalTokens = solicitudes.stream().mapToInt(Solicitud::getTokensConsumidos).sum();
        return Map.of("totalTokens", totalTokens, "cantidadSolicitudes", solicitudes.size());
    }
}
