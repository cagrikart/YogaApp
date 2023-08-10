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
        response.setUserId(packages.getUser().getId());
        return response;
    }
}
