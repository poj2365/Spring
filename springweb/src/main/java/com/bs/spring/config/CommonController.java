package com.bs.spring.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//모든 컨트롤러에 적용
public class CommonController {
    //initbinder -> parameter형태 맞춰 주는 것
    //ExceptionHandler
    @ExceptionHandler(value=IllegalArgumentException.class)
    public String exceptionHandler(Exception e,
                                   HttpServletRequest request){
        return "common/error/error1";
    }
}
