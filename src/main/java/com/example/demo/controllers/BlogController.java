package com.example.demo.controllers;

import com.example.demo.configs.props.AppInfoProps;
import com.example.demo.models.Post;
import com.example.demo.services.BlogService;
import com.example.demo.utils.client.ClientGlobalVarNames;
import com.example.demo.utils.client.ClientPages;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private AppInfoProps appInfoProps;

    @Autowired
    private BlogService blogService;

    @GetMapping("create")
    public String createBlogPostPage(Model model, Principal principal) {
        model.addAttribute(ClientGlobalVarNames.appName, appInfoProps.getAppName());
        model.addAttribute(ClientGlobalVarNames.isAuthenticated, true);
        return ClientPages.createBlogPage;
    }

    @GetMapping("edit-blog/{postId}")
    public String editBlogPage(Model model, Principal principal, @PathVariable("postId") String postId) {
        Post post = blogService.findPost(Long.parseLong(postId));
        model.addAttribute(ClientGlobalVarNames.appName, appInfoProps.getAppName());
        model.addAttribute(ClientGlobalVarNames.isAuthenticated, true);
        model.addAttribute("post", post);
        return ClientPages.editBlogPage;
    }
}
