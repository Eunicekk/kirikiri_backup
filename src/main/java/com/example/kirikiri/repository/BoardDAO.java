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

    public List<BoardVO> getListAll(){
        return boardMapper.selectAll();
    }

    public List<BoardVO> getListByCategory(String categoryName){
        return boardMapper.selectCategory(categoryName);
    }

    public List<BoardVO> getListByDetailCategory(String detailCategoryName){
        return boardMapper.selectDetailCategory(detailCategoryName);
    }

    public void add(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }

    public void delete(Long boardId){
        boardMapper.delete(boardId);
    }

    public void setBoardVO(BoardVO boardVO){
        boardMapper.update(boardVO);
    }

    public BoardVO findById(Long boardId){
        return boardMapper.select(boardId);
    }
}
