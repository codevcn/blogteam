package com.example.demo.controllers.apis;

import com.example.demo.DTOs.UtilDTOs.Success;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.services.BlogService;
import jakarta.validation.Valid;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blog")
public class BlogAPIController {

    @Autowired
    private BlogService blogService;

    @PostMapping("create")
    public ResponseEntity<Success> createBlog(
        @Valid @RequestBody CreateBlogDTO createBlogDTO,
        Principal principal
    ) {
        blogService.createNewBlog(createBlogDTO, principal);

        return ResponseEntity.status(200).body(new Success(true));
    }
}
