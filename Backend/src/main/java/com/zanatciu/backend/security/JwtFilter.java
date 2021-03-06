package com.zanatciu.backend.security;

import com.zanatciu.backend.config.cache.MyCacheService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider;
    private MyCacheService myCacheService;

    public JwtFilter(
            JwtProvider jwtProvider,
            MyCacheService myCacheService
    ) {

        this.jwtProvider = jwtProvider;
        this.myCacheService = myCacheService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(httpServletRequest);
        try {
            if (token != null && jwtProvider.validateToken(token)) {

                String user = jwtProvider.getUsername(token);
                Authentication auth = null;

                if (myCacheService.isUserValid(user)) {
                    auth = jwtProvider.getAuthentication(token);
                } else {
                    SecurityContextHolder.clearContext();
                }

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
