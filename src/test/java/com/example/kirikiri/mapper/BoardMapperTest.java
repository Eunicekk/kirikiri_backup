package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void selectAllTest(){
        boardMapper.selectAll().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setNationName("Japan");
        boardVO.setCategoryName("구인구직");
        boardVO.setDetailCategoryName("구인");
        boardVO.setBoardTitle("새 제목입니다.");
        boardVO.setBoardContent("새 내용입니다.");
        boardVO.setUserId("aaa");

        boardMapper.insert(boardVO);
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(3L);
        boardVO.setCategoryName("고민상담");
        boardVO.setDetailCategoryName("가정");
        boardVO.setBoardTitle("수정된 제목입니다.");
        boardVO.setBoardContent("수정된 내용입니다.");

        boardMapper.update(boardVO);
    }

    @Test
    public void selectTest(){
    public void updateViewTest(){
        boardMapper.updateView(15L);
    }}

    @Test
    public void selectTest() {
        boardMapper.select(3L);
    }

    @Test
    public void searchTest(){
        boardMapper.search("타이틀").stream().map(BoardVO::toString).forEach(log::info);
    }
}
