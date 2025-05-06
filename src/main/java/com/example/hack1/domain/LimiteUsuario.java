package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LimiteUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoModelo;
    private Integer limiteTokens;
    private Integer limiteSolicitudes;
    private String ventanaTiempo; // ej: "DIARIO", "MENSUAL"

    @ManyToOne
    private Usuario usuario;
}
