package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.CommentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void insertTest(){
        CommentVO commentVO = new CommentVO();
        commentVO.setBoardId(4L);
        commentVO.setCommentContent("안녕안녕");
        commentVO.setUserId("bbbb");

        commentMapper.insert(commentVO);
    }
}
