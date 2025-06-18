package com.bs.spring.board.controller;

import com.bs.spring.board.model.dto.Board;
import com.bs.spring.board.model.service.BoardService;
import com.bs.spring.common.PageFactory;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private Logger log = LogManager.getLogger(BoardController.class);
    private org.slf4j.Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;
    private final PageFactory pageFactory;

    @GetMapping("/searchboard.do")
    public String searchBoard(Model model,
                              @RequestParam(defaultValue = "1") int cPage,
                              @RequestParam(defaultValue = "5") int numPerpage){
        List<Board> boards=boardService
                .searchAll(Map.of("cPage",cPage,"numPerpage",numPerpage));

//        boards.forEach(System.out::println);
        log.debug("boards:"+boards);
        // slf4j 문자열만 가능
        logger.debug("{}",boards);

        model.addAttribute("boards",boards);
        int totalData=boardService.searchAllCount();
        model.addAttribute("totalContents",totalData);
        model.addAttribute("pageBar",
                pageFactory.basicPageBar(cPage,numPerpage,
                        totalData,"searchboard.do"));
        return "board/boardlist";
    }
}
