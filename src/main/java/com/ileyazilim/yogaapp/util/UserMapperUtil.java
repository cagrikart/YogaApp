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
        return userResponse;
    }
}
