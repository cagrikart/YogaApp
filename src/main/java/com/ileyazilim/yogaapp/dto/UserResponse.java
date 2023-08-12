package com.ileyazilim.yogaapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String name;
    private String username;

    private String email;


    private String phoneNumber;
    private String tcNo;
    private LocalDateTime birthday;
    private String birthPlace;
    private String address;
    private String photo;
    private String emergencyContactPersonv1;
    private String emergencyContactPersonv2;
    private String degreeOfProximity;

}
