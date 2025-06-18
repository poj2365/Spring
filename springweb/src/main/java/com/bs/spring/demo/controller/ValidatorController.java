package com.bs.spring.demo.controller;

import com.bs.spring.demo.model.dto.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidatorController {

    @RequestMapping("/validator/demo")
    public String demo(Demo demo,Model model) {
        model.addAttribute("demo",demo);

        return "demo/demovalidator";
    }

   @RequestMapping("/validator.do")
    public String validatorTest(
            @Validated Demo demo,
            BindingResult bindingResult, Model m){

        System.out.println(demo);

        if(bindingResult.hasErrors()){
            System.out.println("에러발생!");
            bindingResult.getAllErrors().forEach(System.out::println);
            return "demo/demovalidator";
        }
       return "redirect:/validator/demo";
   }

}
