package com.example.kirikiri.service;

import com.example.kirikiri.domain.BoardVO;

import java.util.List;

public interface BoardService {


    // 작성한 게시글 조회
    public List<BoardVO> getWrittenBoard(String userId, Integer page);
}
