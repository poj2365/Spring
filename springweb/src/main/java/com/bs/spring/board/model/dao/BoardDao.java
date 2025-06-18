package com.bs.spring.board.model.dao;

import com.bs.spring.board.model.dto.Board;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    List<Board> searchAll(SqlSession session, Map<String,Integer> param);
    int searchAllCount(SqlSession session);
    int insertBoard(SqlSession session, Board board);
}
