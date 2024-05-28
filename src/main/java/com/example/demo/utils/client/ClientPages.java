package com.example.demo.utils.client;

public class ClientPages {

    public static final String internalErrorPage = "500-page";
    public static final String notFoundPage = "404-page";
    public static final String unauthorizationPage = "403-page";
    public static final String homePage = "home-page";
    public static final String loginPage = "login-page";
    public static final String registerPage = "register-page";
    public static final String accountPage = "account-page";
    public static final String contactPage = "contact-page";
    public static final String createBlogPage = "create-blog-page";
    public static final String editBlogPage = "edit-blog-page";

    public class AdminPages {

        private static final String adminPrefix = "admin/";

        public static final String dashboardPage = adminPrefix + "dashboard-page";
    }
}
