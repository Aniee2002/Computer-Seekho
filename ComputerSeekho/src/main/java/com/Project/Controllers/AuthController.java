package com.Project.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/signIn")
    ResponseEntity<String> signIn() {
        return ResponseEntity.ok("Sign In successfull");
    }

}
