package br.com.fiap.library.security;

import br.com.fiap.library.entity.User;
import br.com.fiap.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
@AllArgsConstructor
public class JwtUserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Username not found " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), new ArrayList<>()
        );
    }
}
