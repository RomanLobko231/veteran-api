package com.rvs.api.controller;

import com.rvs.api.model.auth.AuthRequest;
import com.rvs.api.model.auth.AuthResponse;
import com.rvs.api.security.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody AuthRequest request){
        String token = authenticationService.loginUserReturnToken(request.getPrincipal(), request.getCredentials());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
