package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.services.abstracts.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationService reservationService;

    @GetMapping("/listReservation")
    public DataResult<List<ReservationResponse>> listReservation() {
        return this.reservationService.listReservation();
    }

    @GetMapping("/{userId}")
    public DataResult<List<Reservation>> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);

    }

    @PostMapping("/createReservation")
    public Result createReservation(@RequestBody ReservationRequest reservationRequest) {
        return this.reservationService.createReservation(reservationRequest);
    }
}
