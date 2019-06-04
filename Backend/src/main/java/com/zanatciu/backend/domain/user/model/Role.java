package com.zanatciu.backend.domain.user.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    JOB_PROVIDER,
    SERVICE_PROVIDER,
    JOB_SEEKER,
    SERVICE_SEEKER;

    private String getName(){
        return this.name();
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
