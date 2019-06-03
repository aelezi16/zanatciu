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

    private ConcurrentHashMap<String, HashSet<String> > loadCache;
    private JwtProvider jwtProvider;

    @Autowired
    public MyCacheCleanser(
            ConcurrentHashMap<String, HashSet<String> > loadCache,
            JwtProvider jwtProvider
    ){
        this.loadCache = loadCache;
        this.jwtProvider = jwtProvider;
    }

    @Scheduled(fixedDelay = MyCacheConfig.MAX_DURATION)
    public void cleanse(){
        loadCache.forEach((key, val)->{
            val.forEach(tokenVal ->{
                if(jwtProvider.getExpiration(tokenVal).getTime() < new Date().getTime()){
                    loadCache.get(key).remove(tokenVal);
                }
            });
        });
    }


}
