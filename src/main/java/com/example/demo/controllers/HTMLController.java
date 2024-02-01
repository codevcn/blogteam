package com.example.demo.controllers;

import com.example.demo.DAOs.PostDAO;
import com.example.demo.models.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private PostDAO postDAO;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home-page";
    }

    @GetMapping("hood")
    public String hoodPage(Model model) {
        List<Post> posts = postDAO.findAll();

        model.addAttribute("posts", posts);
        model.addAttribute("vcnUIGIOIOI", "Bem MI /VCN/ VCN Trans 111");

        return "hood-page";
    }
}
