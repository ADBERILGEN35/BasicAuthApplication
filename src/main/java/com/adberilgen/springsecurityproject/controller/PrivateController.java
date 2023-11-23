package com.adberilgen.springsecurityproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public String helloUserPrivate() {
        return "Hello private User";
    }

    @GetMapping("/user")
    public String helloUserRolePrivate() {
        return "Hello private role USER";
    }

    @GetMapping("/admin")
    public String helloAdminRolePrivate() {
        return "Hello private role ADMIN";
    }
}