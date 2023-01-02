package com.example.kirikiri.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @NoArgsConstructor
public class ScrapVO {
//    CREATE TABLE TBL_SCRAP(
//            SCRAP_ID NUMBER CONSTRAINT PK_SCRAP PRIMARY KEY,
//            USER_ID VARCHAR2(1000) NOT NULL,
//    BOARD_ID NUMBER NOT NULL,
//    SCRAP_REGISTER_DATE DATE DEFAULT SYSDATE,
//    CONSTRAINT FK_SCRAP_USER FOREIGN KEY(USER_ID) REFERENCES TBL_USER(USER_ID),
//    CONSTRAINT FK_SCRAP_BOARD FOREIGN KEY(BOARD_ID) REFERENCES TBL_BOARD(BOARD_ID)
//            );
    private Long scrapId;
    private String userId;
    private Long boardId;
    private String scrapRegisterDate;
}
