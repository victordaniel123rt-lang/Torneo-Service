package com.vdgarcia.Torneo_Service.service.inter;

import com.vdgarcia.Torneo_Service.dto.JugadorDTO;

import java.util.List;

public interface JugadorService {
    List<JugadorDTO> obtenerTodos();
    JugadorDTO obtenerPorId(Long id);
    JugadorDTO crear(JugadorDTO dto);
    JugadorDTO actualizar(Long id, JugadorDTO dto);
    JugadorDTO eliminar(Long id);
}
