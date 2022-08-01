package com.hspedu.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    private R doOtherException( Exception ex){

        ex.printStackTrace();
        return new  R("服务器繁忙，请稍后再试");
    }
}
