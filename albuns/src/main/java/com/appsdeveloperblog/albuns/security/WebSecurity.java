package com.appsdeveloperblog.albuns.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;


@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    
    @Override
    protected
    void configure(HttpSecurity http) throws Exception{

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        // logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass conf");
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/albuns") //To any Get to /users
                // .hasAuthority("SCOPE_profile") //check if have scope to profile
                .hasRole("developer")
                // .hasAnyAuthority("ROLE_developer")
                // .hasAnyRole("developer", "user")
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(jwtAuthenticationConverter);
    }
}
