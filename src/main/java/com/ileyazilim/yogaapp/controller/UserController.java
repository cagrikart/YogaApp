package com.ileyazilim.yogaapp.controller;

import com.ileyazilim.yogaapp.core.utilities.results.DataResult;
import com.ileyazilim.yogaapp.core.utilities.results.SuccessDataResult;
import com.ileyazilim.yogaapp.dto.UserResponse;
import com.ileyazilim.yogaapp.entities.Reservation;
import com.ileyazilim.yogaapp.entities.User;
import com.ileyazilim.yogaapp.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PreAuthorize("hasAnyAuthority('ROLE_USER') ")
    @GetMapping("/{userId}")
    public DataResult<List<UserResponse>> listUserId(@PathVariable Long userId) {
        return userService.listUserId(userId);

    }
}
