package com.vdgarcia.Torneo_Service.dto;
import lombok.*;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class JugadorDTO {
    private Long id;
    private String nombre;
    private String nickName;
    private Integer nivel;
    private Integer puntos;
    private Boolean activo;
    private Long equipo;
}
