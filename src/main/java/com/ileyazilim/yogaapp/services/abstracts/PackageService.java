package com.ileyazilim.yogaapp.services.abstracts;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.dto.ReservationRequest;
import com.ileyazilim.yogaapp.dto.ReservationResponse;
import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.entities.Reservation;

import java.util.List;

public interface PackageService {
    DataResult<List<PackageResponse>> listPackage();
    DataResult<List<Package>> getPackageByUserId(Long userId);
    //Result createPackage(ReservationRequest reservationRequest);
}
