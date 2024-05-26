package com.example.demo.services;

import com.example.demo.DAOs.PostDAO;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.models.Post;
import com.example.demo.utils.exceptions.BaseException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogService {

    @Autowired
    private PostDAO postDAO;

    public void createNewBlog(CreateBlogDTO createBlogDTO, Principal principal) throws BaseException, IOException {
        Post post = new Post();

        post.setHashtag(createBlogDTO.getHashtag());
        post.setMainContent(createBlogDTO.getMainContent());
        post.setTitle(createBlogDTO.getTitle());
        post.setUserID(principal.getName());
        post.setIsPrivate(false);

        postDAO.create(post);
    }
}
