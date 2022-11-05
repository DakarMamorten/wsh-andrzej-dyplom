package com.dyplom.service;

import com.dyplom.domain.User;
import com.dyplom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> shawAll(){
        return userRepository.findAll();
    }
}
