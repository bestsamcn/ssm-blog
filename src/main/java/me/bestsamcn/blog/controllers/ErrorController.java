package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public Response handleException(Exception e){
        return Response.error("exception: "+e.getMessage());
    }
}
