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
    public List<BoardVO> getListAllOrderByLikes(){
        return boardMapper.selectAllByLikes();
    }
    public List<BoardVO> getListAllOrderByViews(){
        return boardMapper.selectAllByViews();
    }

    public List<BoardVO> getListByCategory(BoardVO boardVO){
        return boardMapper.selectCategory(boardVO);
    }
    public List<BoardVO> getListByCategoryOrderByLikes(BoardVO boardVO){
        return boardMapper.selectCategoryByLikes(boardVO);
    }
    public List<BoardVO> getListByCategoryOrderByViews(BoardVO boardVO){
        return boardMapper.selectCategoryByViews(boardVO);
    }

    public List<BoardVO> getListByDetailCategory(BoardVO boardVO){
        return boardMapper.selectDetailCategory(boardVO);
    }
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardVO boardVO){
        return boardMapper.selectDetailCategoryByLikes(boardVO);
    }
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardVO boardVO){
        return boardMapper.selectDetailCategoryByViews(boardVO);
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

    public void updateBoardView(Long boardId) {
        boardMapper.updateView(boardId);
    }

    public BoardVO findById(Long boardId){
        return boardMapper.select(boardId);
    }

    public List<BoardVO> WrittenBoard(String userId, Integer page){
        return boardMapper.selectWritten(userId, page);
    };
}
