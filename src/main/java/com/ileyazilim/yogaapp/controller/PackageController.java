package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.services.abstracts.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/package")
@AllArgsConstructor
public class PackageController {
    private PackageService packageService;
    public DataResult<List<PackageResponse>> listPackage() {
        return this.packageService.listPackage();
    }

    @GetMapping("/{userId}")
    public DataResult<List<Package>> getPackageByUserId(Long userId) {
        return this.packageService.getPackageByUserId(userId);
    }
}
