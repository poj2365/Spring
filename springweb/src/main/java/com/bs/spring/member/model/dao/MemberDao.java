package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

public interface MemberDao {
    Member searchById(SqlSession session, String id);
    int saveMember(SqlSession session,Member member);
}
