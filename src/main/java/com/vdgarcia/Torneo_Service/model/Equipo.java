package com.vdgarcia.Torneo_Service.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "equipo")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String juego;
    private Boolean activo;
    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

}
