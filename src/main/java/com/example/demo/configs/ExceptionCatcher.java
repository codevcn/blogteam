package com.example.demo.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionCatcher {

    @Value("${spring.application.name}")
    private String appName;

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleAnyException(Exception exception) {
        System.out.printf("\n>>> run this Any Exception catcher");
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        System.out.print(exception);
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler({ DataAccessException.class })
    public ResponseEntity<String> handleDataAccessException(DataAccessException exception) {
        System.out.printf("\n>>> run this DataAccessException catcher");
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        System.out.print(exception);
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        System.out.printf("\n>>> run this RuntimeException catcher");
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        System.out.print(exception);
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ExceptionHandler({ NoResourceFoundException.class })
    public String handleNoResourceFoundException(NoResourceFoundException exception, Model model) {
        System.out.printf("\n>>> run this NoResourceFoundException catcher");
        System.out.printf("\n>>> ::::::::::::::::::::: \n");
        System.out.print(exception);
        System.out.printf("\n>>> ::::::::::::::::::::: \n");

        model.addAttribute("appName", appName);

        return "404-page";
    }
}
