package com.pavan.springsecurityjwt.filter;

import com.pavan.springsecurityjwt.util.jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class jwtrequestfilter extends OncePerRequestFilter {


    @Autowired
    private MyUserDetailsService userDetailsService;


    @Autowired
    private jwtutil Jwtutils;

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
