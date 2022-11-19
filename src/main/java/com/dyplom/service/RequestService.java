package com.dyplom.service;

import com.dyplom.domain.Request;
import com.dyplom.domain.Status;
import com.dyplom.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dyplom.util.UserUtil.getAuthorizedUserName;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    private final RequestRepository requestRepository;

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public List<Request> findAllByUser() {
        return requestRepository.findAllByUsername(getAuthorizedUserName());
    }

    @Transactional
    public void approveRequest(Long requestId) {
        log.info("Start processing request with id: {} for approve", requestId);
        requestRepository.findById(requestId).ifPresent(request -> request.setStatus(Status.APPROVED));
    }

    @Transactional
    public void rejectRequest(Long requestId) {
        log.info("Start processing request with id: {} for reject", requestId);
        requestRepository.findById(requestId).ifPresent(request -> request.setStatus(Status.REJECTED));
    }
}
