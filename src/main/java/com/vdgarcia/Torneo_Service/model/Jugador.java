package com.vdgarcia.Torneo_Service.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugador")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nickName;
    private Integer nivel;
    private Integer puntos;
    private Boolean activo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
