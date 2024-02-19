package com.example.demo.controllers;

import com.example.demo.configs.props.AppInfoProps;
import com.example.demo.utils.client.ClientGlobalVarNames;
import com.example.demo.utils.client.ClientPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private AppInfoProps appInfoProps;

    @GetMapping("create")
    public String createBlogPost(Model model) {
        model.addAttribute(ClientGlobalVarNames.appName, appInfoProps.getAppName());
        return ClientPages.createBlogPage;
    }
}
