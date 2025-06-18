package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.MemberDao;
import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Member searchById(String userId,String password)
    {
        Member m =memberDao.searchById(sqlSession,userId);

        if(m!=null
                && passwordEncoder.matches(password,m.getPassword())){
            return m;
        }
        return null;
    }

    @Override
    public int saveMember(Member member) {
        return memberDao.saveMember(sqlSession,member);
    }
}
