package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.repository.ReservationRepository;
import com.ileyazilim.yogaapp.services.abstracts.ReservationService;
import com.ileyazilim.yogaapp.util.ReservationMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapperUtil mapperUtil;
    @Override
    public DataResult<List<ReservationResponse>> listReservation() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponse>responses = reservations.stream().map(mapperUtil :: listReservation).collect(Collectors.toList());
        return new SuccessDataResult<>(responses,"list reservation");
    }
    public DataResult<List<Reservation>> getReservationsByUserId(Long userId) {
        return new SuccessDataResult<>(reservationRepository.findByUserId(userId));
    }

    @Override
    public Result createReservation(ReservationRequest reservationRequest) {
        Reservation reservations = mapperUtil.postReservation(reservationRequest);
        Reservation savedReservation =this.reservationRepository.save(reservations);
        return new SuccessDataResult<>(savedReservation,"added reservation");
    }
}
