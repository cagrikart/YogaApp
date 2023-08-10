package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.repository.PackageRepository;
import com.ileyazilim.yogaapp.services.abstracts.PackageService;
import com.ileyazilim.yogaapp.util.PackageMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {
    private PackageRepository packageRepository;
    private PackageMapperUtil mapperUtil;

    @Override
    public DataResult<List<PackageResponse>> listPackage() {
        List<Package> packeages = packageRepository.findAll();
        List<PackageResponse> savedPackeages = packeages.stream().map(mapperUtil:: listPackage).collect(Collectors.toList());
        return new SuccessDataResult<>(savedPackeages,"listed package");
    }

    @Override
    public DataResult<List<Package>> getPackageByUserId(Long userId) {
        List<Package> packeages = packageRepository.findByUserId(userId);
        List<PackageResponse> savedPackeages = packeages.stream().map(mapperUtil:: listPackage).collect(Collectors.toList());
        return new SuccessDataResult<>(savedPackeages,"listed userId");
    }
}
