package com.ileyazilim.yogaapp.dto;

import com.ileyazilim.yogaapp.entities.Package;
import com.ileyazilim.yogaapp.entities.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class PackageResponse {
    private String name;
    private double price;

    private Long userId;

}
