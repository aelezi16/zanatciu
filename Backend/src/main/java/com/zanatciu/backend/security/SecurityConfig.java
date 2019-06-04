package com.zanatciu.backend.security;

import com.zanatciu.backend.config.cache.MyCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtProvider jwtProvider;
    private MyCacheService myCacheService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

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

        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .apply(new JwtFilterConfigurer(jwtProvider, myCacheService));

    }
}
