package com.example.event_nexus_main.AdminRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event_nexus_main.model.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    Optional<Admin> findByRollNumber(String rollNumber);  // Method to fetch by roll number

}
