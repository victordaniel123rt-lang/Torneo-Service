package com.vdgarcia.Torneo_Service.service.impl;

import com.vdgarcia.Torneo_Service.dto.EquipoDTO;
import com.vdgarcia.Torneo_Service.mapper.Mapper;
import com.vdgarcia.Torneo_Service.model.Equipo;
import com.vdgarcia.Torneo_Service.model.Jugador;
import com.vdgarcia.Torneo_Service.repository.EquipoRepository;
import com.vdgarcia.Torneo_Service.repository.JugadorRepository;
import com.vdgarcia.Torneo_Service.service.inter.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repository;
    private final JugadorRepository jugadorRepository;

    @Override
    public List<EquipoDTO> obtenerTodos() {
        return repository.findAll().stream().map(Mapper::toEquipoDTO).toList();
    }

    @Override
    public EquipoDTO obtenerPorId(Long id) {
        Equipo equipo = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Equipo No encontrado")
        );
        return Mapper.toEquipoDTO(equipo);
    }

    @Override
    public EquipoDTO crear(EquipoDTO dto) {
        Equipo equipo = Mapper.toEquipo(dto);
        Equipo creado = repository.save(equipo);
        return Mapper.toEquipoDTO(creado);
    }

    @Override
    public EquipoDTO actualizar(Long id, EquipoDTO dto) {
        Equipo equipo = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Equipo No encontrado")
        );
        Mapper.updateEquipo(dto,equipo);
        Equipo actualizado = repository.save(equipo);
        return Mapper.toEquipoDTO(actualizado);
    }

    @Override
    public EquipoDTO eliminar(Long id) {
        Equipo equipo = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Equipo No encontrado")
        );
        repository.delete(equipo);
        return Mapper.toEquipoDTO(equipo);
    }

    @Override
    public EquipoDTO addJugador(Long equipoId, Long jugadorId) {
        Equipo equipo = repository.findById(equipoId).orElseThrow(
                ()-> new IllegalArgumentException("Equipo No encontrado")
        );
        List<Jugador> jugadores = equipo.getJugadores();
        Jugador jugador = jugadorRepository.findById(jugadorId).orElseThrow(
                ()-> new IllegalArgumentException("Jugador no encontrado")
        );
        Optional<Jugador> existe = jugadores.stream().filter(j->j.getNombre().toUpperCase().equals(jugador.getNombre().toUpperCase())).findAny();
        if (existe.isPresent()){
            throw new IllegalArgumentException("El jugador que intentas ingresar al equipo ya existe");
        }
        jugadores.add(jugador);
        repository.save(equipo);
        return Mapper.toEquipoDTO(equipo);
    }

    @Override
    public EquipoDTO eliminarJugador(Long equipoId, Long jugadorId) {
        return null;
    }
}
