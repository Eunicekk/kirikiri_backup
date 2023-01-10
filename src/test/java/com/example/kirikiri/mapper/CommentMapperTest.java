package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.CommentVO;
import com.example.kirikiri.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    BoardService boardService;

    @Test
    public void insertTest(){
        CommentVO commentVO = new CommentVO();
        commentVO.setBoardId(22L);
        commentVO.setCommentContent("안녕안녕");
        commentVO.setUserId("bbbb");

        commentMapper.insert(commentVO);
    }

    @Test
    public void selectTest(){

        log.info(boardService.getBoardDTO(22L).toString());
    }
}
