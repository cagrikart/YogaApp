package com.ileyazilim.yogaapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservation,package,lessons"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String username, String email, String password, String phoneNumber, String tcNo, LocalDateTime birthday, String birthPlace, String address, String photo, String emergencyContactPersonv1, String emergencyContactPersonv2, String degreeOfProximity) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.tcNo = tcNo;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.address = address;
        this.photo = photo;
        this.emergencyContactPersonv1 = emergencyContactPersonv1;
        this.emergencyContactPersonv2 = emergencyContactPersonv2;
        this.degreeOfProximity = degreeOfProximity;
        this.roles = roles;
    }

    private String username;

    private String email;

    private String password;
   private String phoneNumber;
    private String tcNo;
    private LocalDateTime  birthday;
    private String birthPlace;
    private String address;
    private String photo;
    private String emergencyContactPersonv1;
    private String emergencyContactPersonv2;
    private String degreeOfProximity;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



}
