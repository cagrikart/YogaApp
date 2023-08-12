package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.PackageResponse;
import com.ileyazilim.yogaapp.dto.PackageUpdateRequest;
import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.PackageRepository;
import com.ileyazilim.yogaapp.repository.UserRepository;
import com.ileyazilim.yogaapp.services.abstracts.PackageService;
import com.ileyazilim.yogaapp.util.PackageMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {
    private PackageRepository packageRepository;
    private UserRepository userRepository;
    private PackageMapperUtil mapperUtil;

    @Override
    public DataResult<List<PackageResponse>> listPackage() {
        List<Package> packeages = packageRepository.findAll();
        List<PackageResponse> savedPackeages = packeages.stream().map(mapperUtil::listPackage).collect(Collectors.toList());
        return new SuccessDataResult<>(savedPackeages, "listed package");
    }

    @Override
    public DataResult<List<Package>> getPackageByUserId(Long userId) {
        List<Package> packeages = packageRepository.findByUsersId(userId);
        List<PackageResponse> savedPackeages = packeages.stream().map(mapperUtil::listPackage).collect(Collectors.toList());
        return new SuccessDataResult<>(savedPackeages, "listed userId");
    }

    @Override

    public Result updatePackageStatus(PackageUpdateRequest request, Long packageId) {
        Optional<Package> packageDb = this.packageRepository.findById(packageId);
        Optional<User> userDb = this.userRepository.findById(request.getUserId());
        User user = userDb.get();
        Package aPackage=  null;
        if (packageDb.isPresent()) {
            aPackage = packageDb.get();
            aPackage.setStatus(request.isStatus());
            aPackage.setUsers(user);
        }
        Package updatePackage =packageRepository.save(aPackage);
        return new SuccessDataResult<>(updatePackage,"update package status");
    }
}
