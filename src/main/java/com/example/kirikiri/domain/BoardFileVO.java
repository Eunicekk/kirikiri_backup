package com.example.kirikiri.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @NoArgsConstructor
public class BoardFileVO {
//    BOARD_FILE_ID NUMBER CONSTRAINT PK_BOARD_FILE PRIMARY KEY,
//    BOARD_FILE_NAME VARCHAR2(1000),
//    BOARD_FILE_PATH VARCHAR2(1000),
//    BOARD_FILE_UUID VARCHAR2(1000),
//    BOARD_FILE_IMAGE_CHECK CHAR(1),
//    BOARD_FILE_SIZE VARCHAR2(1000),
//    BOARD_ID NUMBER

    private int boardFileId;
    private String boardFileName;
    private String boardFilePath;
    private String boardFileUuid;
    private char boardFileImageCheck;
    private String boardFileSize;
    private int boardId;

    @Builder
    public BoardFileVO(String boardFileName, String boardFilePath, String boardFileUuid, char boardFileImageCheck, String boardFileSize, int boardId) {
        this.boardFileName = boardFileName;
        this.boardFilePath = boardFilePath;
        this.boardFileUuid = boardFileUuid;
        this.boardFileImageCheck = boardFileImageCheck;
        this.boardFileSize = boardFileSize;
        this.boardId = boardId;
    }
}
