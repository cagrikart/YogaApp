package com.ileyazilim.yogaapp.services.abstracts;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.Result;
import com.ileyazilim.yogaapp.dto.UserRequest;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.entities.User;

import java.util.List;

public interface UserService {
    DataResult<List<UserResponse>> listUser();
    DataResult<List<UserResponse>> listUserId(Long userId);
    Result updateUser(Long userId, UserRequest userRequest);

}
