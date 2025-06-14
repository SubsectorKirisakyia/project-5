package com.example.dormitory_management.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, MANAGER, STAFF;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
