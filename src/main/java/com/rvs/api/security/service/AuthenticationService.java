package com.rvs.api.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService tokenService;

    public AuthenticationService(UserService userService, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = jwtTokenService;
    }

    public String loginUserReturnToken (String principal, String credentials){
        UserDetails user = userService.loadUserByUsername(principal);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(principal, credentials));

        return tokenService.generateToken(user);
    }
}
