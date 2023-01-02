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
    public Integer getCountAll(){
        return boardDAO.getCountAll();
    }

    @Override
    public Integer getCountCategory(BoardVO boardVO) {
        return boardDAO.getCountCategory(boardVO);
    }
    @Override
    public Integer getCountDetailCategory(BoardVO boardVO) {
        return boardDAO.getCountDetailCategory(boardVO);
    }

    @Override
    public Integer getCountSearchResult(String keyword) {
        return boardDAO.getCountSearchResult(keyword);
    }

    @Override
    public Integer getCountCategorySearchResult(BoardDTO boardDTO) {
        return boardDAO.getCountCategorySearchResult(boardDTO);
    }

    @Override
    public Integer getCountByUser(String userId) {
        return boardDAO.getCountByUser(userId);
    }

    @Override
    public List<BoardVO> getListAll(Integer page) {
        return boardDAO.getListAll(page);
    }

    @Override
    public List<BoardVO> getListAllOrderByLikes(Integer page) {
        return boardDAO.getListAllOrderByLikes(page);
    }

    @Override
    public List<BoardVO> getListAllOrderByViews(Integer page) {
        return boardDAO.getListAllOrderByViews(page);
    }

    @Override
    public List<BoardVO> getListByCategory(BoardDTO boardDTO) {
        return boardDAO.getListByCategory(boardDTO);
    }

    @Override
    public List<BoardVO> getListByCategoryOrderByLikes(BoardDTO boardDTO) {
        return boardDAO.getListByCategoryOrderByLikes(boardDTO);
    }

    @Override
    public List<BoardVO> getListByCategoryOrderByViews(BoardDTO boardDTO) {
        return boardDAO.getListByCategoryOrderByViews(boardDTO);
    }

    @Override
    public List<BoardVO> getListByDetailCategory(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategory(boardDTO);
    }

    @Override
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategoryOrderByViews(boardDTO);
    }

    @Override
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategoryOrderByLikes(boardDTO);
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
    public List<BoardVO> getFivePosts(String categoryName) {
        return boardDAO.getFivePosts(categoryName);
    }


    @Override
    public List<BoardVO> getWrittenBoard(String userId, Integer page) {
        return boardDAO.writtenBoard(userId, page);
    }

    @Override
    public List<BoardVO> search(BoardDTO boardDTO) {
        return boardDAO.searchByTitle(boardDTO);
    }

    @Override
    public List<BoardVO> searchByCategory(BoardDTO boardDTO) {
        return boardDAO.searchByTitleByCategory(boardDTO);
    }

}
