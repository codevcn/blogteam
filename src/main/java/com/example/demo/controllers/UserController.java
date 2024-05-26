package com.example.demo.controllers;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.configs.props.AppInfoProps;
import com.example.demo.utils.client.ClientGlobalVarNames;
import com.example.demo.utils.client.ClientPages;

@Controller
public class UserController {

    @Autowired
    private AppInfoProps appInfoProps;

    @GetMapping("account")
    public String accountPage(Model model, Principal principal) {
        model.addAttribute(ClientGlobalVarNames.appName, appInfoProps.getAppName());
        model.addAttribute(ClientGlobalVarNames.isAuthenticated, principal != null);
        return ClientPages.accountPage;
    }
}
