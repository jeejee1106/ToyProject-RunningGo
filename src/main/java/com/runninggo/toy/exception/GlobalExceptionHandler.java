package com.runninggo.toy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException exception) {
        log.error("404Exception 발생 : ", exception);
        return "/error/custom404";
    }

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception, Model model) {
        log.error("Exception 발생 : ", exception);
        model.addAttribute("exception", exception);
        return "/error/custom500";
    }
}