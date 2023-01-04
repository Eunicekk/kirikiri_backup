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
    //전체 게시물 수
    @Override
    public Integer getCountAll(){
        return boardDAO.getCountAll();
    }
    //카테고리 게시물 수
    @Override
    public Integer getCountCategory(BoardVO boardVO) {
        return boardDAO.getCountCategory(boardVO);
    }
    //세부 카테고리 게시물 수
    @Override
    public Integer getCountDetailCategory(BoardVO boardVO) {
        return boardDAO.getCountDetailCategory(boardVO);
    }
    //검색 게시물 수
    @Override
    public Integer getCountSearchResult(String keyword) {
        return boardDAO.getCountSearchResult(keyword);
    }
    //카테고리 검색 게시물 수
    @Override
    public Integer getCountCategorySearchResult(BoardDTO boardDTO) {
        return boardDAO.getCountCategorySearchResult(boardDTO);
    }
    //마이페이지 유저 게시물 수
    @Override
    public Integer getCountByUser(String userId) {
        return boardDAO.getCountByUser(userId);
    }

    //전체 게시물 리스트
    @Override
    public List<BoardVO> getListAll(Integer page) {
        return boardDAO.getListAll(page);
    }
    //추천수로 정렬
    @Override
    public List<BoardVO> getListAllOrderByLikes(Integer page) {
        return boardDAO.getListAllOrderByLikes(page);
    }
    //조회수로 정렬
    @Override
    public List<BoardVO> getListAllOrderByViews(Integer page) {
        return boardDAO.getListAllOrderByViews(page);
    }

    //카테고리 게시물 리스트
    @Override
    public List<BoardVO> getListByCategory(BoardDTO boardDTO) {
        return boardDAO.getListByCategory(boardDTO);
    }
    //카테고리 게시물 리스트 추천수로 정렬
    @Override
    public List<BoardVO> getListByCategoryOrderByLikes(BoardDTO boardDTO) {
        return boardDAO.getListByCategoryOrderByLikes(boardDTO);
    }
    //카테고리 게시물 리스트 조회수로 정렬
    @Override
    public List<BoardVO> getListByCategoryOrderByViews(BoardDTO boardDTO) {
        return boardDAO.getListByCategoryOrderByViews(boardDTO);
    }

    //세부 카테고리 게시물 리스트
    @Override
    public List<BoardVO> getListByDetailCategory(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategory(boardDTO);
    }
    //세부 카테고리 게시물 리스트 조회수로 정렬
    @Override
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategoryOrderByViews(boardDTO);
    }
    //세부 카테고리 게시물 리스트 추천수로 정렬
    @Override
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardDTO boardDTO) {
        return boardDAO.getListByDetailCategoryOrderByLikes(boardDTO);
    }

    //게시물 추가
    @Override
    public void add(BoardVO boardVO) {
        boardDAO.add(boardVO);
    }
    //게시물 삭제
    @Override
    public void delete(Long boardId) {
        boardDAO.delete(boardId);
    }
    //게시물 수정
    @Override
    public void edit(BoardVO boardVO) {
        boardDAO.setBoardVO(boardVO);
    }
    //게시물 상세 보기
    @Override
    public BoardVO getBoard(Long boardId) {
        boardDAO.updateBoardView(boardId);
        return boardDAO.findById(boardId);
    }

    //메인화면 각 카테고리별 게시물
    @Override
    public List<BoardVO> getFivePosts(String categoryName) {
        return boardDAO.getFivePosts(categoryName);
    }
    //왼쪽 사이드 Top Posts
    @Override
    public List<BoardVO> getFivePopularPosts() {
        return boardDAO.getFivePopularPosts();
    }
    //왼쪽 사이드 Top Writers
    @Override
    public List<BoardDTO> getFivePopularWriters(){
        return boardDAO.getFivePopularWriters();
    }

    //유저 아이디로 쓴 게시물 리스트
    @Override
    public List<BoardVO> getWrittenBoard(String userId, Integer page) {
        return boardDAO.writtenBoard(userId, page);
    }

    //검색된 게시물 리스트
    @Override
    public List<BoardVO> search(BoardDTO boardDTO) {
        return boardDAO.searchByTitle(boardDTO);
    }
    //카테고리 내에서 검색된 게시물 리스트
    @Override
    public List<BoardVO> searchByCategory(BoardDTO boardDTO) {
        return boardDAO.searchByTitleByCategory(boardDTO);
    }
}
