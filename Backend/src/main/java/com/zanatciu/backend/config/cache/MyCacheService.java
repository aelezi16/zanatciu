package com.zanatciu.backend.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCacheService {

    private MyCache myCache;

    @Autowired
    public MyCacheService(MyCache myCache){
        this.myCache = myCache;
    }

    
}
