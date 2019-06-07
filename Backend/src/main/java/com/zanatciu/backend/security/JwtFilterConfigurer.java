package com.zanatciu.backend.security;

import com.zanatciu.backend.config.cache.MyCacheService;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtProvider jwtProvider;
    private MyCacheService myCacheService;

    public JwtFilterConfigurer(JwtProvider jwtProvider, MyCacheService myCacheService) {
        this.myCacheService = myCacheService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtFilter customFilter = new JwtFilter(jwtProvider, myCacheService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
