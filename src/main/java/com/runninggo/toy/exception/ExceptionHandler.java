//package com.runninggo.toy.exception;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//
//@ControllerAdvice
//@Slf4j
//public class ExceptionHandler {
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public String defaultExceptionHandler(Exception exception, Model model) {
//        model.addAttribute("exception", exception);
//
//        log.error("exception", exception);
//
//        return "/error/error_test";
//    }
//}