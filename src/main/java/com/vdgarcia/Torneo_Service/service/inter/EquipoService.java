package com.vdgarcia.Torneo_Service.service.inter;

import com.vdgarcia.Torneo_Service.dto.EquipoDTO;

import java.util.List;

public interface EquipoService {
    List<EquipoDTO> obtenerTodos();
    EquipoDTO obtenerPorId(Long id);
    EquipoDTO crear(EquipoDTO dto);
    EquipoDTO actualizar(Long id, EquipoDTO dto);
    EquipoDTO eliminar(Long id);
    EquipoDTO addJugador(Long equipoId,Long jugadorId);
    EquipoDTO eliminarJugador(Long equipoId,Long jugadorId);
}
