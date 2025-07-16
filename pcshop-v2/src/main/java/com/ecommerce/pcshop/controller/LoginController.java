package com.ecommerce.pcshop.controller;

import com.ecommerce.pcshop.dto.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("loginRequest") @Valid LoginRequest loginRequest,
                              BindingResult bindingResult,
                              HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    );

            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            HttpSession session = request.getSession(true);
            session.setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext()
            );
            return "redirect:/";

        } catch (AuthenticationException e) {
            bindingResult.reject("login.failed", "Invalid username or password");
            return "login";
        }
    }

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}


