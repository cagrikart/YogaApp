package com.ileyazilim.yogaapp.repository;

import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package,Long> {
    List<Package> findByUserId(Long userId);

}
