package com.example.demo.controllers;

import com.example.demo.DAOs.PostDAO;
import com.example.demo.DAOs.UserDAO;
import com.example.demo.models.Post;
import com.example.demo.models.User;
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

    @GetMapping
    public ResponseEntity<List<User>> home() {
        System.out.printf("\n>>> run this sql controller \n");
        System.out.println();

        // // create user 
        // User new_user = new User();
        // new_user.setAddress("23 Ha Noi, Phuc Chau, TP.Quang Binh");
        // new_user.setAvatar("https://i.pinimg.com/originals/b3/0a/f9/b30af9c341665cd68115d496ed70f034.jpg");
        // new_user.setBirthday("1998-02-28");
        // new_user.setEmail("user-email-1@mail.ru");
        // new_user.setFullName("nguyễn ánh nguyệt");
        // new_user.setGender("nữ");
        // new_user.setRole("user");
        // new_user.setPassword("uSer123");

        // int user_create_res = userDAO.create(new_user);
        // System.out.printf(">>> row created: %d \n", user_create_res);

        // // create post
        // Post new_post = new Post();
        // new_post.setBackground(
        //     "https://c4.wallpaperflare.com/wallpaper/95/659/754/anime-girl-yuri-wallpaper-preview.jpg"
        // );
        // new_post.setIsPrivate(false);
        // new_post.setMainContent(
        //     "As a genre, yuri does not inherently target a single gender demographic, unlike its male homoerotic counterparts yaoi (marketed towards a female audience) and gay manga (marketed towards a gay male audience). Although yuri originated as a genre targeted towards a female audience, yuri works have been produced that target a male audience, as in manga from Comic Yuri Hime's male-targeted sister magazine Comic Yuri Hime S."
        // );
        // new_post.setTitle("What is yuri genre?");
        // new_post.setUserID("user-email-1@mail.ru");

        // int post_create_res = postDAO.create(new_post);
        // System.out.printf(">>> row created: %d \n", post_create_res);

        // find
        List<Post> posts = postDAO.findAll();

        for (Post post : posts) {
            System.out.printf("\n>>> single post ( \n");
            System.out.print(post);
            System.out.printf("\n>>> ) single post \n");
        }

        Post post = postDAO.findById(7);
        System.out.printf("\n>>> single post ( \n");
        System.out.print(post);
        System.out.printf("\n>>> ) single post \n");

        List<User> users = userDAO.findAll();

        for (User user : users) {
            System.out.printf("\n>>> single user ( \n");
            System.out.print(user);
            System.out.printf("\n>>> ) single user \n");
        }

        int count_posts = postDAO.count();
        System.out.printf(">>> count posts: %d \n", count_posts);

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
