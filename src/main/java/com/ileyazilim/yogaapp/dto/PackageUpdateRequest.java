package com.ileyazilim.yogaapp.dto;

import lombok.Data;

@Data
public class PackageUpdateRequest {
    private Long id;
    private String name;
    private double price;
    private String packageTime;
    private String startingTime;
    private String finishingTime;
    private String remaningDay;
    private boolean status;

    private Long userId;

}
