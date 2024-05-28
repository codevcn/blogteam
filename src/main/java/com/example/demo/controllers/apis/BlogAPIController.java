package com.example.demo.controllers.apis;

import com.example.demo.DTOs.UtilDTOs;
import com.example.demo.DTOs.UtilDTOs.Success;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.services.BlogService;
import com.example.demo.utils.exceptions.BaseException;
import jakarta.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blog")
public class BlogAPIController {

    @Autowired
    private BlogService blogService;

    @PostMapping("create")
    public ResponseEntity<Success> createBlog(@Valid @RequestBody CreateBlogDTO createBlogDTO, Principal principal)
        throws BaseException, IOException {
        blogService.createNewBlog(createBlogDTO, principal);

        return ResponseEntity.status(200).body(new Success(true));
    }

    @GetMapping("search")
    public ResponseEntity<List<UtilDTOs.SearchPost>> searchBlog(
        @RequestParam(name = "title", defaultValue = "") String title) {
        List<UtilDTOs.SearchPost> posts = blogService.searchPosts(title);
        return ResponseEntity.ok(posts);
    }
}
