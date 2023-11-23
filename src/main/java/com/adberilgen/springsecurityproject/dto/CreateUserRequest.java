package com.adberilgen.springsecurityproject.dto;

import com.adberilgen.springsecurityproject.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {

}