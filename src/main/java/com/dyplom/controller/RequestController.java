package com.dyplom.controller;

import com.dyplom.domain.dto.RequestDTO;
import com.dyplom.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/list")
    public String list(Model model) {
        //TODO divide logic to separate controller
        model.addAttribute("requests", requestService.findAll());
        model.addAttribute("user_requests", requestService.findAllByUser());
        return "request/list";
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
    public String add(RequestDTO dto) {
        requestService.add(dto);
        return "redirect:/request/list";
    }
}
