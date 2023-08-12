package com.ileyazilim.yogaapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LessonsResponse {
    private Long id;

    private LocalDateTime dateTime;
    private LocalDateTime startingDate;
    private LocalDateTime finishingDate;

    private String session;

    private String process;
    private Long userId;
}
