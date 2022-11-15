package com.dyplom.service;

import com.dyplom.domain.Request;
import com.dyplom.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public List<Request> findAll(){
        return requestRepository.findAll();
    }
}
