package com.example.kirikiri.service;

import com.example.kirikiri.domain.BoardDTO;
import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("board") @Primary
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO;

    @Override
    public List<BoardVO> getListAll() {
        return boardDAO.getListAll();
    }

    @Override
    public List<BoardVO> getListAllOrderByLikes() {
        return boardDAO.getListAllOrderByLikes();
    }

    @Override
    public List<BoardVO> getListAllOrderByViews() {
        return boardDAO.getListAllOrderByViews();
    }

    @Override
    public List<BoardVO> getListByCategory(BoardVO boardVO) {
        return boardDAO.getListByCategory(boardVO);
    }

    @Override
    public List<BoardVO> getListByCategoryOrderByLikes(BoardVO boardVO) {
        return boardDAO.getListByCategoryOrderByLikes(boardVO);
    }

    @Override
    public List<BoardVO> getListByCategoryOrderByViews(BoardVO boardVO) {
        return boardDAO.getListByCategoryOrderByViews(boardVO);
    }

    @Override
    public List<BoardVO> getListByDetailCategory(BoardVO boardVO) {
        return boardDAO.getListByDetailCategory(boardVO);
    }

    @Override
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardVO boardVO) {
        return boardDAO.getListByDetailCategoryOrderByViews(boardVO);
    }

    @Override
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardVO boardVO) {
        return boardDAO.getListByDetailCategoryOrderByLikes(boardVO);
    }

    @Override
    public void add(BoardVO boardVO) {
        boardDAO.add(boardVO);
    }

    @Override
    public void delete(Long boardId) {
        boardDAO.delete(boardId);
    }

    @Override
    public void edit(BoardVO boardVO) {
        boardDAO.setBoardVO(boardVO);
    }

    @Override
    public BoardVO getBoard(Long boardId) {
        boardDAO.updateBoardView(boardId);
        return boardDAO.findById(boardId);
    }
    @Override
    public List<BoardVO> getWrittenBoard(String userId, Integer page) {
        return boardDAO.WrittenBoard(userId, page);
    }
}
