package com.bs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.io.StringBufferInputStream;
import java.util.Locale;

@Controller
@RequestMapping("/national")
public class NationalController {

    @Autowired
    private WebApplicationContext context;

    @GetMapping
    public String test(Model m, String local){
        Locale locale=null;
        Object[] param=null;
        if(local!=null&&local.equals("en")){
            locale=new Locale("en","US");
            param=new Object[]{"bsYoo","teacher"};
        }else{
            locale=new Locale("ko","KR");
            param=new Object[]{"유병승","강사"};
        }
        String info=context.getMessage("info",null,locale);
        m.addAttribute("info",info);

        String myinfo=context.getMessage("myinfo",param,
                locale);
        m.addAttribute("myinfo",myinfo);





        //값 가져오기
        String infoEn=context.getMessage("info",null, Locale.US);
        String infoKo=context.getMessage("info",null,Locale.KOREA);

        m.addAttribute("infoEn",infoEn);
        m.addAttribute("infoKo",infoKo);

        String myinfoEn=context.getMessage("myinfo",
                new Object[]{"bslove","teacher"},Locale.US);
        m.addAttribute("myinfoEn",myinfoEn);
        String myinfoKo=context.getMessage("myinfo",
                new Object[]{"유병승","강사"},Locale.KOREA);
        m.addAttribute("myinfoKo",myinfoKo);

        return "common/nation";
    }
}
