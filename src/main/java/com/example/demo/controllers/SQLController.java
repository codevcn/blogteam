package com.example.demo.controllers;

import com.example.demo.DAOs.CategoryDAO;
import com.example.demo.DAOs.PostDAO;
import com.example.demo.DAOs.UserDAO;
import com.example.demo.models.Category;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.models.joins.PostWithCategory;
import com.example.demo.utils.ResponseBodyDTO.Success;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sql")
public class SQLController {

    @Autowired
    PostDAO postDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("posts")
    public ResponseEntity<Success> posts() {
        System.out.printf("\n>>> run this sql controller: posts \n");
        System.out.println();

        Post new_post = new Post();
        new_post.setBackground(
            "https://static1.srcdn.com/wordpress/wp-content/uploads/2021/03/Feature-Image-Cat-Heroes-in-Movies-.jpg"
        );
        new_post.setCategoryID("food");
        new_post.setPrivate(false);
        new_post.setMainContent("Trở thành NEET không tốt đâu =((");
        new_post.setTitle("Hôm nay ăn gì?");
        new_post.setUserID("user-email-1@mail.ru");
        postDAO.create(new_post);

        // find
        // List<PostWithCategory> post_with_category = postDAO.findPostWithCategory(10);
        // System.out.printf("\n>>> ::::::::::post_with_category:::::::::::( \n");
        // System.out.print(post_with_category);
        // System.out.printf("\n>>> ::::::::::post_with_category:::::::::::) \n");

        // delete
        // int deleted_count = postDAO.deleteByCategory("food");
        // System.out.printf("\n>>> deleted_count: %d \n", deleted_count);

        List<Post> posts = postDAO.findAll();
        for (Post post : posts) {
            System.out.printf("\n>>> :::::::::: single post :::::::::::( \n");
            System.out.print(post);
            System.out.printf("\n>>> :::::::::: single post :::::::::::) \n");
        }

        // int count_posts = postDAO.count();
        // System.out.printf("\n>>> count posts: %d \n", count_posts);

        return ResponseEntity.status(HttpStatus.OK).body(new Success());
    }

    @GetMapping("users")
    public ResponseEntity<Success> users() {
        System.out.printf("\n>>> run this sql controller: users \n");
        System.out.println();

        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.printf("\n>>> ::::::::::single user:::::::::::( \n");
            System.out.print(user);
            System.out.printf("\n>>> ::::::::::single user:::::::::::) \n");
        }

        return ResponseEntity.status(HttpStatus.OK).body(new Success());
    }

    @GetMapping("categories")
    public ResponseEntity<Success> categories() {
        System.out.printf("\n>>> run this sql controller: categories \n");
        System.out.println();

        // delete
        categoryDAO.deleteById("food");

        // create
        Category new_category = new Category();
        new_category.setId("food");
        new_category.setDescription("Phân loại các bài đăng liên quan đến thực phẩm");
        new_category.setName("Thực phẩm");
        categoryDAO.create(new_category);

        List<Category> categories = categoryDAO.findAll();
        for (Category category : categories) {
            System.out.printf("\n>>> :::::::::::single category::::::::::( \n");
            System.out.print(category);
            System.out.printf("\n>>> :::::::::::single category::::::::::) \n");
        }

        return ResponseEntity.status(HttpStatus.OK).body(new Success());
    }
}
