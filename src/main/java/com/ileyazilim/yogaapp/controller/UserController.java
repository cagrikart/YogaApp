package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @GetMapping("/listUser")
    public DataResult<List<UserResponse>> listUser() {
        return this.userService.listUser();
    }
}
