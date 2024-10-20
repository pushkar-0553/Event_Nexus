package com.example.event_nexus_main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.event_nexus_main.AdminRepository.AdminRepository;
import com.example.event_nexus_main.model.Admin;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public String login(@RequestParam String rollNumber, @RequestParam String password, Model model) {
        Optional<Admin> adminOptional = adminRepository.findByRollNumber(rollNumber);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(password)) {
                model.addAttribute("name", admin.getName());
                model.addAttribute("role", admin.getRole());

                // Redirect based on role
                if ("Student".equals(admin.getRole())) {
                    return "student_dashboard"; // Redirect to Student Dashboard
                } else if ("Coordinator".equals(admin.getRole())) {
                    return "coordinator_dashboard"; // Redirect to Coordinator Dashboard
                } else if ("Faculty".equals(admin.getRole())) {
                    return "faculty_dashboard"; // Redirect to Faculty Dashboard
                }
            }
        }

        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
}
