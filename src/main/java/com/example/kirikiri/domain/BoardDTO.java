package com.example.kirikiri.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @NoArgsConstructor
public class BoardDTO {
//    BOARD_ID NUMBER CONSTRAINT PK_BOARD PRIMARY KEY,
//    NATION_NAME VARCHAR2(1000) NOT NULL,
//    CATEGORY_NAME VARCHAR2(1000) NOT NULL,
//    DETAIL_CATEGORY_NAME VARCHAR2(1000) NOT NULL,
//    BOARD_TITLE VARCHAR2(1000) NOT NULL,
//    BOARD_CONTENT VARCHAR2(2000) NOT NULL,
//    BOARD_REGISTER_DATE DATE DEFAULT SYSDATE,
//    BOARD_UPDATE_DATE DATE DEFAULT SYSDATE,
//    BOARD_VIEWS NUMBER DEFAULT 0,
//    BOARD_LIKES NUMBER DEFAULT 0,
//    BOARD_SCRAPS NUMBER DEFAULT 0,
//    USER_ID VARCHAR2(1000) NOT NULL

    private Long boardId;
    private String nationName;
    private String categoryName;
    private String detailCategoryName;
    private String boardTitle;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;
    private int boardViews;
    private int boardLikes;
    private String userId;
    private int sortType;
    private String keyword;

    @Builder
    public BoardDTO(String nationName, String categoryName, String detailCategoryName, String boardTitle, String boardContent, String userId) {
        this.nationName = nationName;
        this.categoryName = categoryName;
        this.detailCategoryName = detailCategoryName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userId = userId;
    }

    public BoardVO chageBoardVO(){
        BoardVO boardVO = new BoardVO(boardId, nationName, categoryName, detailCategoryName, boardTitle, boardContent, boardRegisterDate, boardUpdateDate, boardViews, boardLikes, userId);
        return boardVO;
    }
}
