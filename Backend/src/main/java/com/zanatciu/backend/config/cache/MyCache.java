package com.zanatciu.backend.config.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@EnableScheduling
public class MyCache {


    private final Long MAX_DURATION = 60*60*1000l;
    private ConcurrentHashMap<String, String> cache;

    public MyCache(){
        this.cache = loadCache();
    }


    @Bean
    private ConcurrentHashMap<String, String> loadCache(){
        return new ConcurrentHashMap<String, String>();
    }


}
