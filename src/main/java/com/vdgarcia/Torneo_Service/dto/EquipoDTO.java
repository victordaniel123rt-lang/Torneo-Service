package com.vdgarcia.Torneo_Service.dto;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String juego;
    private Boolean activo;
    private List<JugadorDTO> jugadores;
}
