package com.appsdeveloperblog.resourceserver.controllers;

import com.appsdeveloperblog.resourceserver.response.UserRest;

import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    Environment env;

    @GetMapping("/status/check")
    public String status(){
        try {
            
        } catch (Exception e) {
            return "Working on port: " + env.getProperty("local.server.port");
        }
        return "Working, but there is an error on reading port function!";
    }

    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    // @Secured("ROLE_develo")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Delete user with id "+id + " and JWT subject: " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("Rômulo", "98fe69f7-ae4f-4861-9e44-790ed1e795c3", "Franklin");
    }
}
