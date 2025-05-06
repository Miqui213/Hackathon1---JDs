package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RestriccionModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoModelo;
    private Integer limiteMensualTokens;
    private Integer limiteDiarioSolicitudes;

    @ManyToOne
    private Empresa empresa;
}

