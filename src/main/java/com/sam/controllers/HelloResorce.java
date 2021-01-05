package com.sam.controllers;

import com.sam.models.AuthenticationRequest;
import com.sam.models.AuthenticationResponse;
import com.sam.services.MyUserDetailsService;
import com.sam.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
public class HelloResorce {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            logger.info("Authentication Body { } "+authenticationRequest.toString());
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));



        } catch (BadCredentialsException b) {
            logger.info("Incorrect Username or Password  { } ");
            throw new Exception("Incorrect Username or Password " + b);
        }

        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwtToken = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
