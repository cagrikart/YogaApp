package com.ileyazilim.yogaapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String packageTime;
    private String startingTime;
    private String finishingTime;
    private String remaningDay;
    private boolean status;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = true)
    private User users;


}
