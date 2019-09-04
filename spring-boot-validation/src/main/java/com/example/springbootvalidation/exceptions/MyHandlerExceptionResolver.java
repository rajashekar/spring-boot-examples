package com.example.springbootvalidation.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o,
            Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof java.lang.ArithmeticException) {
            mv.setViewName("mathError");
        }
        if (e instanceof java.lang.NullPointerException) {
            mv.setViewName("nullPointerError");
        }
        mv.addObject("exception", e.toString());
        return mv;
    }
}