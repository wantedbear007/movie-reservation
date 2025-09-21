package com.wantedbear.movieres.repository;

import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wantedbear.movieres.entity.Reservation;
import com.wantedbear.movieres.entity.Horario;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByHorarioId(Long horarioId);
    boolean existsByHorario(Horario horario);

    @Query("SELECT r FROM Reservation r JOIN r.horario h JOIN h.movie_id m WHERE m.id = :movieId")
    List<Reservation> findReservationsByMovieId(@Param("movieId") Long movieId);
}
