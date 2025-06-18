package com.bs.spring.controller;

import com.bs.spring.common.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/exceptiontest")
public class ExceptionTestController {
    //   ExceptionHandler등록하기
    @ExceptionHandler(value=IllegalArgumentException.class)
    public String exceptionHandler(Exception e,
                                   HttpServletRequest request){
        return "common/error/error1";
    }
    @ExceptionHandler(value=MyException.class)
    public String exceptionHandler2(Exception e,
                                   HttpServletRequest request){
        return "common/error/error3";
    }



    @GetMapping("/illegal")
    public String illegalTest() {
        if(1==1)
            throw new IllegalArgumentException("매개변수가 잘못됐습니다.");
        return "redirect:/";
    }
    @GetMapping("/nullPoint")
    public String nullPoint() {
        String name=null;
        name.length();
        return "redirect:/";
    }

    @GetMapping("/my")
    public String my() {
        if(1==1)
            throw new MyException("나의 예외발생", LocalDateTime.now());
        return "redirect:/";
    }
}
