package com.zanatciu.backend.config.cache;

import com.zanatciu.backend.security.JwtProvider;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MyCacheCleanser {

    private ConcurrentHashMap<String, String > loadCache;
    private JwtProvider jwtProvider;

    @Autowired
    public MyCacheCleanser(
            ConcurrentHashMap<String, String> loadCache,
            JwtProvider jwtProvider
    ){
        this.loadCache = loadCache;
        this.jwtProvider = jwtProvider;
    }

    @Scheduled(fixedDelay = 3600000l)
    public void cleanse(){
        loadCache.forEach((key, val)->{
                if(jwtProvider.getExpiration(val).getTime() < new Date().getTime()){
                    loadCache.remove(key);
                }
        });
    }


}
