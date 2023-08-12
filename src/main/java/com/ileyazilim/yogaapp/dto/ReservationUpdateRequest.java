package com.ileyazilim.yogaapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationUpdateRequest {
    private Long id;

    private String process;
    private Long userId;

}
