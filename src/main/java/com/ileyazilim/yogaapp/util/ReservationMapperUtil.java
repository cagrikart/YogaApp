package com.ileyazilim.yogaapp.util;

import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ReservationMapperUtil {

    private UserRepository userRepository;

    public ReservationResponse listReservation(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setProcess(reservation.getProcess());
        response.setSession(reservation.getSession());
        response.setFinishingDate(reservation.getFinishingDate());
        reservation.setStartingDate(reservation.getStartingDate());
        response.setUserId(reservation.getUser().getId());
        return response;
    }

    public Reservation postReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setSession(reservationRequest.getSession());
        reservation.setProcess(reservationRequest.getProcess());
        Optional<User> userOptional = this.userRepository.findById(reservationRequest.getUserId());
        if (userOptional.isPresent()) {
            reservation.setUser(userOptional.get());
        }
        reservation.setFinishingDate(reservationRequest.getFinishingDate());
        reservation.setStartingDate(reservationRequest.getStartingDate());
        return reservation;
    }
}
