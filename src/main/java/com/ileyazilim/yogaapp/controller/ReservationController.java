package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.config.LoginSecurityService;
import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.dto.ReservationUpdateRequest;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.services.abstracts.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationService reservationService;

    @GetMapping("/listReservation")
    @PreAuthorize("hasAnyAuthority('ROLE_USER') ")

    public DataResult<List<ReservationResponse>> listReservation() {
        return this.reservationService.listReservation();
    }

    @PreAuthorize("hasRole('ROLE_USER') ")
    @GetMapping("/getReservationsByUserId")
    public DataResult<List<Reservation>> getReservationsByUserId() {
        Authentication authenticatedUserInfo = LoginSecurityService.getAuthenticatedUserInfo();
        System.out.println("değişken"+authenticatedUserInfo.getName().toString());
        return reservationService.getReservationsByUserId(authenticatedUserInfo.getName());

    }

    @PostMapping("/createReservation")
    @PreAuthorize("hasAnyAuthority('ROLE_USER') ")
    public Result createReservation(@RequestBody ReservationRequest reservationRequest) {
        return this.reservationService.createReservation(reservationRequest);
    }

    @PostMapping("/updateReservationProcess/{reservationId}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER') ")
    Result updateReservationProcess(@RequestBody ReservationUpdateRequest reservationRequest, @PathVariable Long reservationId){
        return this.reservationService.updateReservationProcess(reservationRequest,reservationId);
    }
}
