package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{
    @Override
    public Member searchById(SqlSession session, String id) {
        return session.selectOne("member.searchById",id);
    }

    @Override
    public int saveMember(SqlSession session, Member member) {
        return session.insert("member.saveMember",member);
    }
}
