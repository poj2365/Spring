package com.bs.spring.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    private long boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private Date boardDate;
    private String boardReadCount;
    private List<Attachment> files;
}
