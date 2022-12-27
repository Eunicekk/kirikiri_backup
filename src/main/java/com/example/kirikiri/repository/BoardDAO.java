package com.example.kirikiri.repository;

import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;





    // 작성한 게시글 조회
    public List<BoardVO> WrittenBoard(String userId, Integer page){
        return boardMapper.selectWritten(userId, page);
    };
}
