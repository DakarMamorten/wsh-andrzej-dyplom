package com.dyplom.service;

import com.dyplom.domain.UserAuth;
import com.dyplom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        return user.map(u -> new UserAuth(
                        u.getUsername(),
                        u.getPassword(),
                        List.of(new SimpleGrantedAuthority(u.getRole().name())),
                        u.getId()))
                .orElseThrow(EntityNotFoundException::new);
    }

}
