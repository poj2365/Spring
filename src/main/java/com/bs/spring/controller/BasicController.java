package com.bs.spring.controller;

import com.bs.spring.model.dto.Animal;
import com.bs.spring.model.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BasicController {

    /* 등록된 springbean 의존성 주입하기 */
    //어노테이션을 이용해서 주입 받음
    //@Autowired를 이용
    //필드선언부, 생성자, setter메소드에서 사용이 가능함
    // 의존성 주입을 받을때 필드명과 beanname이 일치하면 일치하는 springbean을 가져와 주입함.
    // 필드명과 beanname이 일치하지 않을때는 Type을 일치하는 springbean을 주입함
    // springbean이 한개만 등록이 되어있어야 한다.(기본)
    // 여러개 등록했을때는 추가 옵션을 사용한다.
    // @Qualifier 이용
    @Autowired
    @Qualifier("animal3")
    private Animal a1;

    @Autowired(required = false)
    private Person p;

    @Autowired
    private Person person2;

    @Autowired
    private List<Animal> animalList;

    @RequestMapping("/")
    public String index(){
        System.out.println("Animal bean가져오기 "+a1);
        System.out.println("Person" + p);
        System.out.println("Person2" + person2);
        System.out.println("===== list =====");
        animalList.forEach(System.out::println);
        //request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
        return "index";
    }

}
