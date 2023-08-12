package com.ileyazilim.yogaapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String tcNo;
    private LocalDateTime birthday;
    private String birthPlace;
    private String address;
    private String photo;
    private String emergencyContactPersonv1;
    private String emergencyContactPersonv2;
    private String degreeOfProximity;
    private Set<String> role;
}
