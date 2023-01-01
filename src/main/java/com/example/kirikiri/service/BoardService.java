package com.example.kirikiri.service;

import com.example.kirikiri.domain.BoardDTO;
import com.example.kirikiri.domain.BoardVO;

import com.example.kirikiri.repository.BoardDAO;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

public interface BoardService {
    //전체 게시물 조회
    public List<BoardVO> getListAll();
    public List<BoardVO> getListAllOrderByLikes();
    public List<BoardVO> getListAllOrderByViews();

    //특정 게시판 조회
    public List<BoardVO> getListByCategory(BoardVO boardVO);
    public List<BoardVO> getListByCategoryOrderByLikes(BoardVO boardVO);
    public List<BoardVO> getListByCategoryOrderByViews(BoardVO boardVO);

    //특정 게시판 조회
    public List<BoardVO> getListByDetailCategory(BoardVO boardVO);
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardVO boardVO);
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardVO boardVO);

    //게시물 추가
    public void add(BoardVO boardVO);

    //게시물 삭제
    public void delete(Long boardId);

    //게시물 수정
    public void edit(BoardVO boardVO);

    //게시물 조회
    public BoardVO getBoard(Long boardId);

    // 작성한 게시글 조회
    public List<BoardVO> getWrittenBoard(String userId, Integer page);

    @Transactional
    public default List<BoardDTO> searchPosts(String keyword){
        List<BoardDTO> boardDTOList = new ArrayList<>();
        return boardDTOList;
    }
}
