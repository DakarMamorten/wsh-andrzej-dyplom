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
    public RequestDTO findById(@RequestParam Long id) {
       return requestService.findById(id);
    }


    @PostMapping("/approve")
    public String approve(@RequestParam Long requestId) {
        requestService.approveRequest(requestId);
        return "redirect:/request/list";

    }

    @PostMapping("/reject")
    public String reject(@RequestParam Long requestId) {
        requestService.rejectRequest(requestId);
        return "redirect:/request/list";

    }

    @PostMapping("/add")
    public RequestDTO add(@RequestBody RequestDTO dto) {
        return requestService.add(dto);
    }
}
