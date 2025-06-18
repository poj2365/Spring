package com.bs.spring.member.controller;

import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"loginMember"})
@Slf4j // -> private logger log 를 자동으로 만들어줌
public class MemberController {

    @Autowired
    private MemberService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/loginend.do")
    public String login(String userId, String pw, Model model){
        Member m=service.searchById(userId,pw);
        log.debug("loginend:"+m.toString());
        if(m!=null){
//            session.setAttribute("loginMember",m);
            //sendRedirect로 응답할때는 redirect:주소
            //redirect주소는 : controller mapping주소를 작성한다
            model.addAttribute("loginMember",m);
            return "redirect:/";
        }else{
            model.addAttribute("msg","로그인실패");
            model.addAttribute("loc","/");
            return "common/msg";
        }
    }

    @RequestMapping("/logout.do")
//    public String logout(HttpSession session){
//    session.invalidate()
    public String logout(SessionStatus sessionStatus){

        if(!sessionStatus.isComplete()) {
            sessionStatus.setComplete();
        }

        return "redirect:/";
    }

    @RequestMapping("/enrollmember.do")
    public String enrollMember(@ModelAttribute("member") Member member){
        //화면전환용 메소드
        return "member/memberEnroll2";
    }

//    @RequestMapping(value = "/enrollmemberend.do",
//            method= RequestMethod.POST)
    @PostMapping("/enrollmemberend.do")
    public String enrollMemberEnd(@Validated Member member, BindingResult bindResult, Model model){
        if(bindResult.hasErrors()){
            return "member/memberEnroll2";
        }
        String password=member.getPassword();
        member.setPassword(passwordEncoder.encode(password));

        int result=service.saveMember(member);
        if(result<0){
            model.addAttribute("msg","회원가입실패 :(");
            model.addAttribute("loc","/enrollmember.do");
            return "common/msg";
        }
        return "redirect:/";
    }

}
