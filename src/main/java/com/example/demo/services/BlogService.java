package com.example.demo.services;

import com.example.demo.DAOs.PostDAO;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.models.Post;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private PostDAO postDAO;

    public void createNewBlog(CreateBlogDTO createBlogDTO, Principal principal) {
        Post post = new Post();

        String cover_img_url =
            "https://topshare.com.vn/htdocs/images/newsen/2020/03/06/800/sai_gioi_tinh_dung_tinh_yeu_bach_hop_review.jpg";

        post.setBackground(cover_img_url);
        post.setCategoryID(createBlogDTO.getCategoryID());
        post.setMainContent(createBlogDTO.getMainContent());
        post.setTitle(createBlogDTO.getTitle());
        post.setUserID(principal.getName());
        post.setPrivate(false);

        postDAO.create(post);
    }
}
