package com.bs.spring.board.model.service;

import com.bs.spring.board.model.dao.BoardDao;
import com.bs.spring.board.model.dto.Board;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final SqlSession session;
    private final BoardDao boardDao;
//    private Map<String,Object> data;
    //생성자 주입
//    public BoardServiceImpl(SqlSession session, BoardDao boardDao){
//        this.session=session;
//        this.boardDao=boardDao;
//    }

    public Map<String,Object> searchAllBoard(Map<String, Integer> param){
        return Map.of("boards",boardDao.searchAll(session,param),
                "boardCount",boardDao.searchAllCount(session));
    }

    @Override
    public List<Board> searchAll(Map<String, Integer> param) {
        return boardDao.searchAll(session,param);
    }

    @Override
    public int searchAllCount() {
        return boardDao.searchAllCount(session);
    }

    @Override
    public int insertBoard(Board board) {
        return 0;
    }
}
