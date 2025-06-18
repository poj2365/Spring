package com.bs.spring.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
@Component
public class BasicInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //지정된 컨트롤러 메소드가 실행되기 전에 어떤 서비스를 실행
        System.out.println("==== prehandle실행! ====");
        System.out.println("요청주소 : "+request.getRequestURI());

        if(handler instanceof HandlerMethod) {
            //실행되는 컨트롤러와 메소드에 대한 정보확인하기
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("실행컨트롤러 : " + handlerMethod.getBean().getClass().getName());
            System.out.println("실행 메소드 : " + handlerMethod.getMethod().getName());
        }
        Map<String,String[]> param=request.getParameterMap();
        if(param!=null){
            param.forEach((k,v)-> System.out.println(k+" "+ Arrays.toString(v)));
        }

//        request.getRequestDispatcher("/WEB-INF/views/index.jsp")
//                .forward(request,response);

        return true;// 반환형이 true면 컨트롤러 메소드 실행, false 컨트롤러 메소드 실행하지 않음
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        //컨트롤러 메소드가 반환된 후 실행되는 메소드
        System.out.println("==== posthandle실행! ====");
        System.out.println("응답화면 : "+modelAndView.getViewName());
        System.out.println("model : "+modelAndView.getModel());

//        modelAndView.addObject("test","졸지마요~~");
//        modelAndView.setViewName("redirect:/enrollmember.do");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        //화면응답(jsp) 후 실행되는 메소드
        System.out.println("==== aftercompletion실행! ====");

        System.out.println("에러 : "+ex);

    }
}
