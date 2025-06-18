package com.bs.spring.board.model.dao;

import com.bs.spring.board.model.dto.Board;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao{

    @Override
    public List<Board> searchAll(SqlSession session, Map<String, Integer> param) {
        int cPage=param.get("cPage");
        int numPerpage=param.get("numPerpage");
        RowBounds rowBounds
                =new RowBounds((cPage-1)*numPerpage,numPerpage);
        return session.selectList("board.searchAll",null,rowBounds);
    }

    @Override
    public int searchAllCount(SqlSession session) {
        return session.selectOne("board.searchAllCount");
    }

    @Override
    public int insertBoard(SqlSession session, Board board) {
        return 0;
    }
}
