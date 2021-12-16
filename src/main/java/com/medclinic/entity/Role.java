package com.medclinic.entity;

import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CLIENT, DOCTOR, LABORATORY, CASHIER;

    @Override
    public String getAuthority() {
        return name();
    }
}
