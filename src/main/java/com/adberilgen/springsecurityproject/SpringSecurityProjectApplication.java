package com.adberilgen.springsecurityproject;

import com.adberilgen.springsecurityproject.dto.CreateUserRequest;
import com.adberilgen.springsecurityproject.model.Role;
import com.adberilgen.springsecurityproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityProjectApplication implements CommandLineRunner {
    private final UserService userService;

    public SpringSecurityProjectApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData() {
        CreateUserRequest request = CreateUserRequest.builder()
                .name("Oğuzhan")
                .username("adberilgen")
                .password("deneme123")
                .authorities(Set.of(Role.ROLE_USER))
                .build();
        userService.createUser(request);

        CreateUserRequest request2 = CreateUserRequest.builder()
                .name("Deneme")
                .username("dene")
                .password("deneme123")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();
        userService.createUser(request2);

        CreateUserRequest request3 = CreateUserRequest.builder()
                .name("Oğuzhan")
                .username("adberilgen")
                .password("deneme123")
                .authorities(Set.of(Role.ROLE_MOD))
                .build();
        userService.createUser(request3);
    }
}
