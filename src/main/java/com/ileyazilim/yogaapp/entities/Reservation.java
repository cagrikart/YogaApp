package com.ileyazilim.yogaapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startingDate;
    private LocalDateTime finishingDate;

    private String session;

    private String process;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" ,  referencedColumnName = "id")
    private User user;
}
