package com.example.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(BlogException.class)
    public String handle(){
        return "redirect:/blog";
    }
}
