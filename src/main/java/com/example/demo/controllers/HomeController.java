package com.example.demo.controllers;

import com.example.demo.services.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AppInfoService appInfoService;

    @GetMapping({ "/", "/home" })
    public String homePage(Model model) {
        model.addAttribute("appName", appInfoService.getAppName());
        return "home-page";
    }
}
