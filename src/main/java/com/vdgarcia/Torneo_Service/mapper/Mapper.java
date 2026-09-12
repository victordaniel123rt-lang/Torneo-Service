package com.vdgarcia.Torneo_Service.mapper;

import com.vdgarcia.Torneo_Service.dto.EquipoDTO;
import com.vdgarcia.Torneo_Service.dto.JugadorDTO;
import com.vdgarcia.Torneo_Service.dto.TorneoDTO;
import com.vdgarcia.Torneo_Service.model.Equipo;
import com.vdgarcia.Torneo_Service.model.Jugador;
import com.vdgarcia.Torneo_Service.model.Torneo;

import java.util.List;

public class Mapper {

    public static JugadorDTO toJugadorDTO(Jugador entity){
        if (entity==null) return null;

        return JugadorDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .nickName(entity.getNickName())
                .nivel(entity.getNivel())
                .activo(entity.getActivo())
                .equipo(entity.getEquipo().getId())
                .puntos(entity.getPuntos())
                .build();
    }

    public static EquipoDTO toEquipoDTO(Equipo entity){
        if (entity==null) return null;
        List<JugadorDTO> jugadores = entity.getJugadores().stream().map(Mapper::toJugadorDTO).toList();
        return EquipoDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .juego(entity.getJuego())
                .activo(entity.getActivo())
                .torneo(entity.getTorneo().getId())
                .jugadores(jugadores)
                .build();
    }

    public static TorneoDTO toTorneoDTO(Torneo entity){
        if (entity==null) return null;

        List<EquipoDTO> equipos = entity.getEquipos().stream().map(Mapper::toEquipoDTO).toList();
        return TorneoDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .estado(entity.getEstado())
                .maxEquipos(entity.getMaxEquipos())
                .juego(entity.getJuego())
                .equipos(equipos)
                .build();
    }


    public static Jugador toJugador(JugadorDTO dto){
        if (dto == null) return null;

        return Jugador.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .equipo(Equipo.builder().id(dto.getEquipo()).build())
                .activo(dto.getActivo())
                .nickName(dto.getNickName())
                .puntos(dto.getPuntos())
                .nivel(dto.getNivel())
                .build();
    }


    public static Equipo toEquipo(EquipoDTO dto){
        if (dto==null) return null;

        List<Jugador> jugadores = dto.getJugadores().stream().map(Mapper::toJugador).toList();
        return Equipo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .activo(dto.getActivo())
                .juego(dto.getJuego())
                .torneo(Torneo.builder().id(dto.getTorneo()).build())
                .jugadores(jugadores)
                .build();
    }


    public static Torneo toTorneo(TorneoDTO dto){
        if (dto==null) return null;
        List<Equipo> equipos = dto.getEquipos().stream().map(Mapper::toEquipo).toList();
        return Torneo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .juego(dto.getJuego())
                .maxEquipos(dto.getMaxEquipos())
                .equipos(equipos)
                .build();
    }








}
