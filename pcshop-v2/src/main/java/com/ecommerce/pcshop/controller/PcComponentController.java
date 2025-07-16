package com.ecommerce.pcshop.controller;

import com.ecommerce.pcshop.service.PcComponentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PcComponentController {

    private final PcComponentService pcComponentService;

    public PcComponentController(PcComponentService pcComponentService) {
        this.pcComponentService = pcComponentService;
    }

    @GetMapping("/components")
    public String viewComponents(Model model) {
        model.addAttribute("components", pcComponentService.getAllComponents());
        return "components";
    }
}
