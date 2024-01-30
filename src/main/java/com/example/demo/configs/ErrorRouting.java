package com.example.demo.configs;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorRouting implements ErrorController {

    @RequestMapping("/error")
    public String handleInternalError() {
        return "500-page";
    }
}
