package com.android.ecommerce.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.model.User;
import com.android.ecommerce.service.AuthentificationService;

@RestController
@RequestMapping("api/auth")
public class AuthentificationController {
    
    @Autowired
    private AuthentificationService authentificationService;
    
    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return authentificationService.inscription(user);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestMap) {
        return authentificationService.login(requestMap);
    }
}
