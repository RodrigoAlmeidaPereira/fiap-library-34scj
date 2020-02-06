package br.com.fiap.library.controller;

import br.com.fiap.library.dto.*;
import br.com.fiap.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @PostMapping("/login")
    public JwtDTO login(AuthDTO authDTO) {
        return service.login(authDTO);
    }

    @PostMapping
    public UserDTO create(CreateUserDTO createUserDTO) {
        return service.create(createUserDTO);
    }
}
