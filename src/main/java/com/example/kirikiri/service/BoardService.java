package com.example.kirikiri.service;

import com.example.kirikiri.domain.BoardDTO;
import com.example.kirikiri.domain.BoardVO;

import com.example.kirikiri.repository.BoardDAO;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

public interface BoardService {

    public Integer getCountAll();
    public Integer getCountCategory(BoardVO boardVO);
    public Integer getCountDetailCategory(BoardVO boardVO);
    public Integer getCountSearchResult(String keyword);
    public Integer getCountCategorySearchResult(BoardDTO boardDTO);
    public Integer getCountByUser(String userId);

    //전체 게시물 조회
    public List<BoardVO> getListAll(Integer page);
    public List<BoardVO> getListAllOrderByLikes(Integer page);
    public List<BoardVO> getListAllOrderByViews(Integer page);

    //특정 게시판 조회
    public List<BoardVO> getListByCategory(BoardDTO boardDTO);
    public List<BoardVO> getListByCategoryOrderByLikes(BoardDTO boardDTO);
    public List<BoardVO> getListByCategoryOrderByViews(BoardDTO boardDTO);

    //특정 게시판 조회
    public List<BoardVO> getListByDetailCategory(BoardDTO boardDTO);
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardDTO boardDTO);
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardDTO boardDTO);

    //게시물 추가
    public void add(BoardVO boardVO);

    //게시물 삭제
    public void delete(Long boardId);

    //게시물 수정
    public void edit(BoardVO boardVO);

    //게시물 조회
    public BoardVO getBoard(Long boardId);

    public List<BoardVO> getFivePosts(String categoryName);

    // 작성한 게시글 조회
    public List<BoardVO> getWrittenBoard(String userId, Integer page);

    public List<BoardVO> search(BoardDTO boardDTO);

    public List<BoardVO> searchByCategory(BoardDTO boardDTO);

}
