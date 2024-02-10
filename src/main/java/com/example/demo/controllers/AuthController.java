package com.example.demo.controllers;

import com.example.demo.DTOs.auth.CreateAccountDTO;
import com.example.demo.services.AppInfoService;
import com.example.demo.services.UserService;
import com.example.demo.utils.ClientPages;
import com.example.demo.utils.exceptions.AuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String loginPage(Model model) {
        model.addAttribute("appName", appInfoService.getAppName());
        return ClientPages.loginPage;
    }

    @PostMapping("login")
    public String login(Model model) {
        model.addAttribute("appName", appInfoService.getAppName());
        return "redirect:/account";
    }

    @GetMapping("register")
    public String registerPage(Model model) {
        model.addAttribute("appName", appInfoService.getAppName());
        return ClientPages.registerPage;
    }

    @PostMapping("register")
    public String createAccount(
        @NonNull @Valid CreateAccountDTO createAccountDTO,
        BindingResult bindingResult,
        Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("fullName", createAccountDTO.getFullName());
            model.addAttribute("email", createAccountDTO.getEmail());
            model.addAttribute("gender", createAccountDTO.getGender());
            return ClientPages.registerPage;
        }

        try {
            userService.createAccount(createAccountDTO);
        } catch (AuthException exception) {
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("fullName", createAccountDTO.getFullName());
            model.addAttribute("email", createAccountDTO.getEmail());
            model.addAttribute("gender", createAccountDTO.getGender());
            return ClientPages.registerPage;
        }

        return "redirect:/account";
    }

    @GetMapping("account")
    public String accountPage() {
        return ClientPages.accountPage;
    }
}
