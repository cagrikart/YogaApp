package com.ileyazilim.yogaapp.repository;

import com.ileyazilim.yogaapp.entities.Lessons;
import com.ileyazilim.yogaapp.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonsRepository extends JpaRepository<Lessons,Long> {
    List<Lessons> findByUsersId(Long userId);

}
