package com.zanatciu.backend.security;

import com.zanatciu.backend.config.cache.MyCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtProvider jwtProvider;
    private MyCacheService myCacheService;

    @Autowired
    public SecurityConfig(
            JwtProvider jwtProvider,
            MyCacheService myCacheService
    ){
        this.jwtProvider = jwtProvider;
        this.myCacheService = myCacheService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors();

        http.apply(new JwtFilterConfigurer(jwtProvider, myCacheService));
    }


}
