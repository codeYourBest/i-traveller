package com.codeyourbest.itraveller.domain.idm;

public enum RoleEnum {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String roleName;

    public String getRoleName() {
        return roleName;
    }

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }
}
