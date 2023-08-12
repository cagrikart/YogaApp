package com.ileyazilim.yogaapp.services.abstracts;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.dto.ReservationUpdateRequest;
import com.ileyazilim.yogaapp.entities.Reservation;

import java.util.List;

public interface ReservationService {
    DataResult<List<ReservationResponse>> listReservation();
    DataResult<List<Reservation>> getReservationsByUserId(Long userId);
    Result createReservation(ReservationRequest reservationRequest);
    Result updateReservationProcess(ReservationUpdateRequest reservationRequest, Long reservationId);

}
