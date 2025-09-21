package com.wantedbear.movieres.controller;

import org.springframework.web.bind.annotation.*;

import com.wantedbear.movieres.entity.Reservation;
import com.wantedbear.movieres.entity.Horario;
import com.wantedbear.movieres.service.ReservationService;
import com.wantedbear.movieres.service.HorarioService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationService reservationService;
    private final HorarioService horarioService;

    public ReservationController(ReservationService reservationService, HorarioService horarioService) {
        this.reservationService = reservationService;
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }

    @PostMapping("/generate")
    public String generateReservations() {
        List<Horario> horarios = horarioService.getAllHorarios();
        List<Reservation> newReservations = new ArrayList<>();

        for (Horario horario : horarios) {
            if (!reservationService.existsByHorario(horario)) {
                Reservation reservation = new Reservation();
                reservation.setHorario(horario);
                reservation.setSeats(new ArrayList<>()); 
                newReservations.add(reservation);
            }
        }

        reservationService.saveAll(newReservations);

        return newReservations.size() + " nuevas reservas creadas";
    }

}
