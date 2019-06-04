package com.zanatciu.backend.config.cache;

import com.zanatciu.backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MyCacheService {

    private ConcurrentHashMap<String, HashSet<String> > cacheLoad;

    @Autowired
    public MyCacheService(
            ConcurrentHashMap<String, HashSet<String> > cacheLoad
    ){
        this.cacheLoad = cacheLoad;
    }

    public void logUserIn(String token, String username){

        if(cacheLoad.containsKey(username)){

            synchronized (MyCacheService.class) {

                cacheLoad.get(username).add(token);

            }
        }

        cacheLoad.put(username, new HashSet<String>());

        synchronized (MyCacheService.class) {

            cacheLoad.get(username).add(token);

        }
    }

    public void logUserOut(String token, String username){

        if(cacheLoad.containsKey(username)){

            if(!cacheLoad.get(username).isEmpty())
                cacheLoad.remove(token);
        }
    }

    public boolean isUserValid(String username, String token){

        if(cacheLoad.containsKey(username)){
            return cacheLoad.get(username).contains(token);
        }

        return false;
    }
}
