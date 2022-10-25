package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser() {

        return new ResponseEntity<>(null, null, HttpStatus.OK);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAuthentication(
            @RequestHeader("email") String email, @RequestHeader("password") String password
    ) {
        System.out.println("intra aici"+email+" "+password);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(403).body("Wrong password or username!");
        }

        return new ResponseEntity<>(null, null, HttpStatus.OK);

    }

}