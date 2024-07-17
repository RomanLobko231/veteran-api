package com.rvs.api.security.service;

import com.rvs.api.model.auth.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public String loginUserReturnToken (String principal, String credentials){
        UserDetails user = userService.loadUserByUsername(principal);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(principal, credentials));

        return tokenService.generateToken(user);
    }
}
