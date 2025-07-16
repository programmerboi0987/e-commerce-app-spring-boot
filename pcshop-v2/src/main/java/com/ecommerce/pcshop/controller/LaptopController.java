package com.ecommerce.pcshop.controller;

import com.ecommerce.pcshop.service.LaptopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaptopController {

    private final LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
    }

    @GetMapping("/laptops")
    public String viewLaptops(Model model) {
        model.addAttribute("laptops", service.getAllLaptops());
        return "laptops";
    }
}
