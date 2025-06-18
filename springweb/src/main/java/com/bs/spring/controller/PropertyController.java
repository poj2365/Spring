package com.bs.spring.controller;

import com.bs.spring.common.propertydata.PropertyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyData propData;

    @GetMapping
    public String propertyDataCheck(){
        System.out.println(propData.getAppName());
        System.out.println(propData.getDbUrl());
        System.out.println(propData.getStudents());
        return "redirect:/";
    }
}
