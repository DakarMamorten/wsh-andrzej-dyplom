package com.dyplom.service;

import com.dyplom.domain.Role;
import com.dyplom.domain.User;
import com.dyplom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public void add(final Role role, final String username, final String password) {
        var user = new User(role, username, new BCryptPasswordEncoder().encode(password));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
