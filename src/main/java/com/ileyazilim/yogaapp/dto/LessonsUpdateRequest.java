package com.ileyazilim.yogaapp.dto;

import lombok.Data;

@Data
public class LessonsUpdateRequest {
    private Long id;

    private String process;
    private Long userId;

}
