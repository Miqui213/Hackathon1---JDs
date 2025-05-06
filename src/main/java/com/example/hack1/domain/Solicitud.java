package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoModelo;
    private String consulta;
    private String respuesta;
    private Integer tokensConsumidos;
    private LocalDateTime fechaHora;

    @ManyToOne
    private Usuario usuario;
}

