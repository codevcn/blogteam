package com.example.demo.services;

import com.example.demo.DAOs.InteractionDAO;
import com.example.demo.DAOs.PostDAO;
import com.example.demo.DAOs.ReviewDAO;
import com.example.demo.DAOs.UserDAO;
import com.example.demo.DTOs.UtilDTOs;
import com.example.demo.DTOs.blog.CreateBlogDTO;
import com.example.demo.models.Interaction;
import com.example.demo.models.Post;
import com.example.demo.DTOs.UtilDTOs.ReviewWasMade;
import com.example.demo.DTOs.blog.EditBlogDTO;
import com.example.demo.models.Review;
import com.example.demo.utils.exceptions.BaseException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.Principal;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private InteractionDAO interactionDAO;

    @Autowired
    private ReviewDAO reviewDAO;

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

    public Post findPost(Long postId) {
        return postDAO.findById(postId);
    }


    public void cancelLikePost(Long postId, String userId) {
        interactionDAO.deleteById(postId, userId);
    }

    public void likePost(Long postId, String userId) {
        Interaction interaction = new Interaction();
        interaction.setLiked(true);
        interaction.setPostID(postId.intValue());
        interaction.setUserID(userId);
        interactionDAO.create(interaction);
    }

    public ReviewWasMade makeReview(Long postId, String userId, String comment) {
        Review review = new Review();
        review.setComment(comment);
        review.setPostID(postId);
        review.setUserID(userId);
        reviewDAO.create(review);
        Review newReview = reviewDAO.findOne(postId, userId);
        User user = userDAO.findByEmail(userId);
        ReviewWasMade reviewWasMade = new ReviewWasMade(postId,
            new UtilDTOs.UserOfAReview(user.getAvatar(), user.getFullName()), comment, newReview.getCreatedAt());
        return reviewWasMade;
    }

    public void editBlog(Long postId, EditBlogDTO editBlogDTO) {
        Post post = new Post();
        post.setTitle(editBlogDTO.getTitle());
        post.setMainContent(editBlogDTO.getMainContent());
        post.setHashtag(editBlogDTO.getHashtag());
        post.setIsPrivate(editBlogDTO.getIsPrivate());
        postDAO.updateById(postId, post);
    }

    public void deletePost(Long postId) {
        postDAO.deleteById(postId);
    }

}
