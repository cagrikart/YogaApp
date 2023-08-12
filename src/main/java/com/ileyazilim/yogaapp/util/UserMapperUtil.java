package com.ileyazilim.yogaapp.util;

import com.ileyazilim.yogaapp.dto.UserRequest;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperUtil {
    public  UserResponse listUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setTcNo(user.getTcNo());
        userResponse.setBirthday(user.getBirthday());
        userResponse.setBirthPlace(user.getBirthPlace());
        userResponse.setAddress(user.getAddress());
        userResponse.setPhoto(user.getPhoto());
        userResponse.setEmergencyContactPersonv1(user.getEmergencyContactPersonv1());
        userResponse.setEmergencyContactPersonv2(user.getEmergencyContactPersonv2());
        userResponse.setDegreeOfProximity(user.getDegreeOfProximity());
        return userResponse;
    }
}
