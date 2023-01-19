package com.dyplom.controller;

import com.dyplom.domain.dto.RequestDTO;
import com.dyplom.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestRestController {
    private final RequestService requestService;

    @GetMapping("/list/my")
    public List<RequestDTO> listMyRequests() {
        return requestService.findAllByUser();
    }

    @GetMapping("/list/all")
    public List<RequestDTO> listAllRequests() {
        return requestService.findAll();
    }

    @GetMapping
    public RequestDTO findById(@RequestParam Long requestId) {
       return requestService.findById(requestId);
    }


    @PostMapping("/approve")
    public void approve(@RequestParam Long requestId) {
        requestService.approveRequest(requestId);
    }

    @PostMapping("/reject")
    public void reject(@RequestParam Long requestId) {
        requestService.rejectRequest(requestId);
    }

    @PostMapping("/add")
    public RequestDTO add(@RequestBody RequestDTO dto) {
        return requestService.add(dto);
    }
}
