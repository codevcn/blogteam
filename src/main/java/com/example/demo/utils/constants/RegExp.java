package com.example.demo.utils.constants;

public class RegExp {

    public static final String fullNameRegExp = "^.{3,30}$";
    public static final String emailRegExp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
    public static final String passwordRegExp = "^(?=.*[a-zA-Z])(?=.*\\d).{4,}$";
}
