package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.UserRequest;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.UserRepository;
import com.ileyazilim.yogaapp.services.abstracts.UserService;
import com.ileyazilim.yogaapp.util.UserMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapperUtil mapperUtil;
    @Override
    public DataResult<List<UserResponse>> listUser() {
        List<User>users = this.userRepository.findAll();
        List<UserResponse> responses = users.stream().map(mapperUtil::listUser).collect(Collectors.toList());
        return new SuccessDataResult<>(responses,"listed user");
    }

    @Override
    public DataResult<List<UserResponse>> listUserId(Long userId) {
        List<User> users = this.userRepository.findAllById(Collections.singleton(userId)); // Kullanıcıları tek bir kimlikle almak için findAllById kullanıyoruz.
        List<UserResponse> responses = users.stream().map(mapperUtil::listUser).collect(Collectors.toList());
        return new SuccessDataResult<>(responses, "Listed user");
    }
    public Result updateUser(Long userId, UserRequest userRequest) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update the fields from UserRequest

            existingUser.setPhoneNumber(userRequest.getPhoneNumber());
            existingUser.setTcNo(userRequest.getTcNo());
            existingUser.setBirthday(userRequest.getBirthday());
            existingUser.setBirthPlace(userRequest.getBirthPlace());
            existingUser.setAddress(userRequest.getAddress());
            existingUser.setPhoto(userRequest.getPhoto());
            existingUser.setEmergencyContactPersonv1(userRequest.getEmergencyContactPersonv1());
            existingUser.setEmergencyContactPersonv2(userRequest.getEmergencyContactPersonv2());
            existingUser.setDegreeOfProximity(userRequest.getDegreeOfProximity());


            // Save the updated user
            return new SuccessDataResult<>(userRepository.save(existingUser),"güncellendi ");
        }

        return null; // User not found
    }

}
