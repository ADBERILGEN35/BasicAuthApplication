package com.adberilgen.springsecurityproject.dto;

import com.adberilgen.springsecurityproject.model.Role;

import java.util.Set;

public record CreateUserRequest(
    String name,
    String username,
    String  password,
    Set<Role> authorities
){

}