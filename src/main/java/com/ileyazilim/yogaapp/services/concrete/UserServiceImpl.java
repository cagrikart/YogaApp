package com.ileyazilim.yogaapp.services.concrete;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.repository.UserRepository;
import com.ileyazilim.yogaapp.services.abstracts.UserService;
import com.ileyazilim.yogaapp.util.UserMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
