package com.dyplom.controller;

import com.dyplom.domain.car.CarNumber;
import com.dyplom.service.CarService;
import com.dyplom.service.RequestService;
import com.dyplom.service.UserService;
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
    private final CarService carService;
    private final UserService userService;

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
    public String add(CarNumber carNumber,
                      String brand, com.dyplom.domain.car.Model model,
                      int yearOfProduction,
                      String vinNumber) {
        requestService.add(carNumber, brand, model, yearOfProduction, vinNumber);
        return "redirect:/request/list";
    }
}
