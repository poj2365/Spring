package com.bs.spring.common.interceptor;

import com.bs.spring.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberService service;

    @Autowired
    private WebApplicationContext context;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("의존성주입 : "+service);

        String[] webBeans=context.getBeanDefinitionNames();
        Arrays.stream(webBeans).forEach(System.out::println);

        HttpSession session=request.getSession(false);
        if(session==null || session.getAttribute("loginMember")==null){
            request.setAttribute("msg","로그인 후 이용할 수 있습니다.");
            request.setAttribute("loc","/");
            request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
                    .forward(request,response);
            return false;
        }
        return true;
    }
}
