/*
  Created by IntelliJ IDEA.
  User: poj23
  Date: 25. 6. 18.
  Time: 오전 9:47
*/
package com.bs.spring.logtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {
    //1. 로그를 출력할 객체를 생성 -> Logger
    private final Logger log= LogManager.getLogger(LogTestController.class);

    @RequestMapping("/logtest.do")
    public String logTest(){
        //2.Logger객체가 제공하는 메소드를 이용해서 로그 출력하기
        log.debug("Debug출력하기 -> 개발할때 사용");
        log.info("info출력하기 -> application에 대한 정보를 제공할때");
        log.warn("warn출력하기 -> application실행 중 경고메세지 출력할때");
        log.error("error출력하기 -> 에러발생시 (Exception) 출력할때");
        return "redirect:/";
    }
    
}
