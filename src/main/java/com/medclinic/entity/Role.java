package com.medclinic.entity;

import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_CLIENT, ROLE_DOCTOR, ROLE_LABORATORY, ROLE_CASHIER;

    @Override
    public String getAuthority() {
        return name();
    }
}
