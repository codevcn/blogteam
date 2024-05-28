package com.example.demo.services;

import com.example.demo.DAOs.PostDAO;
import com.example.demo.DAOs.UserDAO;
import com.example.demo.DTOs.UtilDTOs;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.utils.exceptions.BaseException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    public void createNewBlog(CreateBlogDTO createBlogDTO, Principal principal) throws BaseException, IOException {
        Post post = new Post();

        post.setHashtag(createBlogDTO.getHashtag());
        post.setMainContent(createBlogDTO.getMainContent());
        post.setTitle(createBlogDTO.getTitle());
        post.setUserID(principal.getName());
        post.setIsPrivate(false);

        postDAO.create(post);
    }

    public List<UtilDTOs.SearchPost> searchPosts(String keyword) {
        List<Post> posts = postDAO.findPostsByKeyword(keyword);
        List<UtilDTOs.SearchPost> searchPostsList = new ArrayList<UtilDTOs.SearchPost>();
        for (Post post : posts) {
            User user = userDAO.findByEmail(post.getUserID());
            searchPostsList.add(new UtilDTOs.SearchPost(post.getId(), post.getTitle(), post.getCreatedAt(),
                post.getBackground(), user, post.getMainContent(), post.getIsPrivate(), post.getHashtag(),
                post.getDeleted(), post.getUpdateAt()));
        }
        return searchPostsList;
    }
}
