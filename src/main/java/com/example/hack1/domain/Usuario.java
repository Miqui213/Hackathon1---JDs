package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String rol;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<LimiteUsuario> limites;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Solicitud> historialSolicitudes;
}

