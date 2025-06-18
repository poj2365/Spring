package com.bs.spring.demo.controller;

import com.bs.spring.demo.model.dto.Address;
import com.bs.spring.demo.model.dto.Demo;
import com.bs.spring.demo.view.MyView;
import com.bs.spring.member.model.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {
    //컨트롤러 클래스에는 매핑메소드를 선언함.
    //@RequestMapping, @GetMapping, @PostMapping ...
    @RequestMapping("/demo.do")
    public String demo(@ModelAttribute("demo") Demo m){
        //화면전환용 메소드
        //등록된 ViewResolver구현체가 자동으로 실행됨
        //ViewResolver가 응답하는대로 화면이 출력
        // /WEB-INF/views/demo/demo.jsp 로 dispatcher.forward()
//        if(1==1)
//            throw new IllegalArgumentException("demo에서 발생!");
//        String name=null;
//        name.length();

        return "demo/demo";
    }
    //서블릿 doGet,doPost메소드처럼 이용하기
    @RequestMapping("/demo1.do")
    public void demo1(HttpServletRequest request,
                      HttpServletResponse response,
                      HttpSession session)
                                        throws ServletException, IOException {
        String name=request.getParameter("devName");
        int age=Integer.parseInt(request.getParameter("devAge"));
        String gender=request.getParameter("devGender");
        String email=request.getParameter("devEmail");
        String[] devlang=request.getParameterValues("devLang");
        System.out.println(name+" "+age+" "+gender+" "+email+" "+ Arrays.toString(devlang));
        Demo d=Demo.builder().devName(name).devAge(age).devGender(gender).devEmail(email)
                .devLang(devlang).build();
        request.setAttribute("demo",d);

//        HttpSession session=request.getSession();
        session.setAttribute("manager","bslove");

        request.getRequestDispatcher("/WEB-INF/views/demo/demoInfo.jsp")
                .forward(request,response);

//        response.setContentType("text/plain;charset=utf-8");
//        PrintWriter out=response.getWriter();

    }
    //파라미터값을 매개변수와 매칭해서 처리하기
    //매개변수를 선언할때 파라미터의 key와 동일하게 변수명을 설정하면
    //파라미터값을 매개변수에 저장해줌
    //request객체, request.getParameter를 하지 않아도 됨.
    //devName, devAge, degEmail, devGender, devLang
    @RequestMapping("/demo2.do")
    public String demo2(String devName, int devAge, String devGender,
                        String devEmail, String[] devLang,
                        Model model, HttpServletRequest request) {

        System.out.println(devName+" "+devAge+" "+devGender+" "+devEmail+" "
                +Arrays.toString(devLang));

        Demo d=Demo.builder()
                .devName(devName).devAge(devAge).devGender(devGender)
                .devEmail(devEmail).devLang(devLang).build();

        //Model객체에 데이터 저장하기
        model.addAttribute("demo",d);//HttpServletRequest와 생명주기가 동일
//        request.setAttribute("demo",new Demo());
        return "demo/demoInfo";
    }

    //매개변수를 선언할때 추가 옵션 설정하기
    //@RequetParam어노테이션을 이용
    // 매개변수와 파라미터 key가 일치하지 않을때 매핑, 기본값을 설정하거나, 필수값이 아님을 처리
    @RequestMapping("/demo3.do")
    public String demo3(
            @RequestParam(value="devName") String name,
            @RequestParam(value="devAge", defaultValue = "10") int age,
            @RequestParam(value="devGender", required = false) String gender,
            @RequestParam(value="devEmail") String email,
            @RequestParam(value="devLang", required = false) String[] lang,
            Model model
    ){
        Demo d=Demo.builder().devName(name).devAge(age).devGender(gender).devEmail(email)
                .devLang(lang).build();

        model.addAttribute("demo",d);

        return "demo/demoInfo";
    }

    //매개변수에 DTO를 선언해서 파라미터값 처리하기
    //Command객체
    //DTO에 필드명와 파라미터의 key값이 일치해야 함

    @RequestMapping("/demo4.do")
    public String demo4(@ModelAttribute("demo") Demo demo, Address address, Model model){
//        System.out.println(demo + " "+birthDay);
        demo.setAddress(address);

        //model.addAttribute("demo",demo);

        System.out.println(demo);

        return "demo/demoInfo";
    }
    //data binding처리하기
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(dateFormat, false));
    }

    //파라미터를 Map으로 전달받기
    @RequestMapping("/demo5.do")
    public String demo5(@RequestParam Map param){
        System.out.println(param);
        return "demo/demoInfo";
    }

    //추가 정보 확인하기
    //Cookie, Session, Header값을 가져오기
    @RequestMapping("/demo6.do")
    public String demo6(@ModelAttribute("demo") Demo demo,
                        @CookieValue("JSESSIONID") String sessionId,
                        @RequestHeader("Accept") String accept,
                        @SessionAttribute(value="lunch",required = false) String lunch,
                        @CookieValue(value="saveId",required = false) String id){
        System.out.println(sessionId);
        System.out.println(accept);
        System.out.printf(lunch);
        System.out.printf(id);

        return "demo/demoInfo";
    }

    //리터값 설정하기
    //String -> 등록된 ViewResolver를 통해서 응답을 처리
    //ModelAndView -> Model에 대한 정보, view에 대한 정보를 한번에 저장하는 객체
    @RequestMapping("/demo7.do")
    public ModelAndView demo7(Demo demo,
                              ModelAndView mv){
        //화면에 전달할 데이터 저장
        mv.addObject("demo",demo);//==Model.addAttribute("",)
        //출력할 화면을 설정
        mv.setViewName("demo/demoInfo");

        ModelAndView mv2=new ModelAndView("demo/demoInfo",
                "test","test");


        //저장된 데이터, 화면설정 확인하기
        Map<String,Object> model=mv.getModel();
        String viewName=mv.getViewName();
        System.out.println(model);
        System.out.println(viewName);

        return mv;
    }
    //데이터(기본,참조형)
    // RestAPI를 구성할때 사용
    // JSON으로 파싱해서 전달
    //반환형에 @ResponseBody어노테이션을 이용
    @RequestMapping("/demo8.do")
    @ResponseBody
    public Demo returnObj(@RequestBody Demo demo){
        System.out.println(demo);
        return Demo.builder().devName("박지송")
                .devAge(30).devGender("남").build();
    }
    //View
    @Autowired
    @Qualifier("myView")
    private View myView;

    @RequestMapping("/demo9.do")
    public View myViewTest(Model m){
        m.addAttribute("test","test");
        m.addAttribute("names",
                List.of("유병승","황민익","JMS","윤우식","박세웅"));
        return myView;
    }



}
