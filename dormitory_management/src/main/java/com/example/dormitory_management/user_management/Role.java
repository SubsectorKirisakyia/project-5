package com.example.dormitory_management.user_management;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, MANAGER, STAFF;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
