package com.ecommerce.pcshop.controller;

import com.ecommerce.pcshop.dto.SignupRequest;
import com.ecommerce.pcshop.model.User;
import com.ecommerce.pcshop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute("signupRequest") @Valid SignupRequest signupRequest,
                               BindingResult bindingResult,
                               HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        // Create and save user
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);

        // Auto-login
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(signupRequest.getUsername(), signupRequest.getPassword());
        authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(token);

        return "redirect:/";
    }
}


