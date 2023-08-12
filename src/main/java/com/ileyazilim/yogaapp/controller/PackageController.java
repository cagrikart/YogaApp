package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.dto.PackageUpdateRequest;
import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.services.abstracts.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasRole('ROLE_USER') ")
    public DataResult<List<Package>> getPackageByUserId(@PathVariable Long userId) {
        return this.packageService.getPackageByUserId(userId);
    }
    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') ")
    public Result updatePackageStatus(@RequestBody PackageUpdateRequest request,@PathVariable Long packageId) {
        return this.packageService.updatePackageStatus(request,packageId);
    }
}
