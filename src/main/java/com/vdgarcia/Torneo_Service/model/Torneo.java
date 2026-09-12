package com.vdgarcia.Torneo_Service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "torneo")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String juego;
    private Integer maxEquipos;
    private Estado estado;
    @OneToMany(mappedBy = "torneo", fetch = FetchType.LAZY)
    private List<Equipo> equipos;   

}
