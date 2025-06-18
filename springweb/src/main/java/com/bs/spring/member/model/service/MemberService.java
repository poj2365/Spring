package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Member;

public interface MemberService {
    Member searchById(String userId,String password);
    int saveMember(Member member);

}
