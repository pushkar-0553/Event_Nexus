package com.example.event_nexus_main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/student_dashboard")
    public String showStudentDashboard() {
        return "student_dashboard"; // Return student dashboard view
    }

    @GetMapping("/coordinator_dashboard")
    public String showCoordinatorDashboard() {
        return "coordinator_dashboard"; // Return coordinator dashboard view
    }

    @GetMapping("/faculty_dashboard")
    public String showFacultyDashboard() {
        return "faculty_dashboard"; // Return faculty dashboard view
    }
}

