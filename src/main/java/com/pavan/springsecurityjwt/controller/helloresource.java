package com.pavan.springsecurityjwt.controller;

import com.pavan.springsecurityjwt.models.AuthanticationResponce;
import com.pavan.springsecurityjwt.models.AuthaticationRequest;
import com.pavan.springsecurityjwt.service.myUserDetailService;
import com.pavan.springsecurityjwt.util.jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloresource {
    @Autowired
    private jwtutil Jwtutil;
    @Autowired
   private myUserDetailService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthaticationRequest authaticationRequest;
    @RequestMapping("/hello")
    public String sayhello() {
        return "helloworld";
    }
    @PostMapping("/Authanticate")
    public ResponseEntity<?>createAuthanticatetoken(@RequestBody AuthaticationRequest authaticationRequest)throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authaticationRequest.getUsername(),authaticationRequest.getPassword()));
        }
        catch (BadCredentialsException ex)
        {
             throw new Exception("username password wrong",ex);
        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(authaticationRequest.getUsername());
        final String jwt=Jwtutil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthanticationResponce(jwt));
    }
} 
