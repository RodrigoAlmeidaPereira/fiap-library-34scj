package br.com.fiap.library.service;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UserDTO;
import br.com.fiap.library.entity.User;
import br.com.fiap.library.repository.UserRepository;
import br.com.fiap.library.security.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private PasswordEncoder passwordEncoder;
    private UserRepository repository;

    @Override
    public JwtDTO login(AuthDTO authDTO) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());
        authenticationManager.authenticate(authToken);

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(jwtTokenUtil.generateToken(authDTO.getUsername()));

        return jwtDTO;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        User entity = repository.save(user);

        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getId());
        dto.setUsername(entity.getUsername());

        return dto;
    }

}
