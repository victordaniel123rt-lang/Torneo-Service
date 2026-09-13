package com.vdgarcia.Torneo_Service.repository;

import com.vdgarcia.Torneo_Service.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo,Long> {
}
