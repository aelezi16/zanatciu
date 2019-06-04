package com.zanatciu.backend.config.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MyCacheConfig {

    @Bean
    public ConcurrentHashMap<String, HashSet<String> > cacheLoad(){
        return new ConcurrentHashMap<String, HashSet<String> >();
    }

}
