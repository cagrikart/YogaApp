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
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


}
