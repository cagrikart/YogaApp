package com.ileyazilim.yogaapp.repository;

import com.ileyazilim.yogaapp.entities.ERole;
import com.ileyazilim.yogaapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}