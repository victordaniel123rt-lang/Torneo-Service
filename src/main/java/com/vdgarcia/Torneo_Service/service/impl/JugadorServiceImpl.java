package com.vdgarcia.Torneo_Service.service.impl;

import com.vdgarcia.Torneo_Service.dto.JugadorDTO;
import com.vdgarcia.Torneo_Service.mapper.Mapper;
import com.vdgarcia.Torneo_Service.model.Jugador;
import com.vdgarcia.Torneo_Service.repository.JugadorRepository;
import com.vdgarcia.Torneo_Service.service.inter.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository repository;

    @Override
    public List<JugadorDTO> obtenerTodos() {
        return repository.findAll().stream().map(Mapper::toJugadorDTO).toList();
    }

    @Override
    public JugadorDTO obtenerPorId(Long id) {
        Jugador jugador = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Jugador no encontrado")
        );
        return Mapper.toJugadorDTO(jugador);
    }

    @Override
    public JugadorDTO crear(JugadorDTO dto) {
        Jugador jugador = Mapper.toJugador(dto);
        Jugador creado = repository.save(jugador);
        return Mapper.toJugadorDTO(creado);
    }

    @Override
    public JugadorDTO actualizar(Long id, JugadorDTO dto) {
        Jugador jugador = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Jugador no encontrado")
        );
        Mapper.updateJugador(dto,jugador);
        Jugador actualizado = repository.save(jugador);
        return Mapper.toJugadorDTO(actualizado);
    }

    @Override
    public JugadorDTO eliminar(Long id) {
        Jugador jugador = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Jugador no encontrado")
        );
        repository.delete(jugador);
        return Mapper.toJugadorDTO(jugador);
    }
}
