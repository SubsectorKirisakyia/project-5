package com.example.dormitory_management.user_management;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    MANAGER,
    STAFF;

    public static Role fromString(String value) {
        return Role.valueOf(value.trim().toUpperCase());
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
