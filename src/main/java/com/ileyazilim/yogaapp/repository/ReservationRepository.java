package com.ileyazilim.yogaapp.repository;

import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByUsersUsername(String  username);
}
