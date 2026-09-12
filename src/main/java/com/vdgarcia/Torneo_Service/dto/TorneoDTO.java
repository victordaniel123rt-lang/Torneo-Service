package com.vdgarcia.Torneo_Service.dto;
import com.vdgarcia.Torneo_Service.model.Estado;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class TorneoDTO {
    private Long id;
    private String nombre;
    private String juego;
    private Integer maxEquipos;
    private Estado estado;
    private List<EquipoDTO> equipos;

}
