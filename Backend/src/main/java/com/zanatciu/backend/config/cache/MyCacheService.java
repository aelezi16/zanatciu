package com.zanatciu.backend.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class MyCacheService {

    private ConcurrentHashMap<String, String > cacheLoad;

    @Autowired
    public MyCacheService(
            ConcurrentHashMap<String, String > cacheLoad
    ){
        this.cacheLoad = cacheLoad;
    }

    public void logUserIn(String token, String username){


         synchronized (MyCacheService.class) {
             cacheLoad.put(username, token);
         }
    }

    public void logUserOut(String username){

        if(cacheLoad.containsKey(username)){
            cacheLoad.remove(username);
        }
    }

    public boolean isUserValid(String username){

            synchronized (MyCacheService.class) {

                if (cacheLoad.containsKey(username)) {
                    return true;
                }

                return false;
            }
        }
    }
