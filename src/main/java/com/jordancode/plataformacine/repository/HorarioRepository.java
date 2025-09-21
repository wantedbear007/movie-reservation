package com.wantedbear.movieres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wantedbear.movieres.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{

}
