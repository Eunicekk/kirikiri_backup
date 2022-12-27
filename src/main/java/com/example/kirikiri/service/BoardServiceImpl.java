package com.example.kirikiri.service;

import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("board")@Primary
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Override
    public List<BoardVO> getWrittenBoard(String userId, Integer page) {
        return boardDAO.WrittenBoard(userId, page);
    }
}
