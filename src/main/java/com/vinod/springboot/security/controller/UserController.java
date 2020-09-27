package com.vinod.springboot.security.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String welcomePage() {
        return "Welcome User";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "User Page";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "Admin Page";
    }
}
