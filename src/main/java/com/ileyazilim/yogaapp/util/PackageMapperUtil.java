package com.ileyazilim.yogaapp.util;

import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.entities.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageMapperUtil {
    public PackageResponse listPackage(Package packages) {
        PackageResponse response = new PackageResponse();
        response.setName(packages.getName());
        response.setPrice(packages.getPrice());
        response.setPackageTime(packages.getPackageTime());
        response.setStatus(packages.isStatus());
        response.setStartingTime(packages.getStartingTime());
        response.setFinishingTime(packages.getFinishingTime());
        response.setRemaningDay(packages.getRemaningDay());
        response.setUserId(packages.getUsers().getId());
        return response;
    }
}
