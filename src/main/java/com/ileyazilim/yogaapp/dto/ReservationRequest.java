package com.ileyazilim.yogaapp.dto;

import com.ileyazilim.yogaapp.entities.User;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    private Long id;
    private LocalDateTime startingDate;
    private LocalDateTime finishingDate;

    private String session;

    private String process;
    private Long userId;
}
