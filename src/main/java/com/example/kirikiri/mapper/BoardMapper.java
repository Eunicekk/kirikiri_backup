package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.BoardDTO;
import com.example.kirikiri.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.List;

@Mapper
public interface BoardMapper {
    //게시글 목록
    public List<BoardVO> selectAll();
    public List<BoardVO> selectAllByLikes();
    public List<BoardVO> selectAllByViews();

    //카테고리 목록

    public List<BoardVO> selectCategory(BoardVO boardVO);
    public List<BoardVO> selectCategoryByLikes(BoardVO boardVO);
    public List<BoardVO> selectCategoryByViews(BoardVO boardVO);
    
    //세부 카테고리 목록
    public List<BoardVO> selectDetailCategory(BoardVO boardVO);
    public List<BoardVO> selectDetailCategoryByLikes(BoardVO boardVO);
    public List<BoardVO> selectDetailCategoryByViews(BoardVO boardVO);

    //게시글 추가
    public void insert(BoardVO boardVO);

    //게시글 삭제
    public void delete(Long boardId);

    //게시글 수정
    public void update(BoardVO boardVO);

    //게시글 조회시 조회수 UP
    public void updateView(Long boardId);

    //게시글 조회
    public BoardVO select(Long boardId);


    public List<BoardVO> search(String keyward);

    // 작성한 게시글 조회
    public List<BoardVO> selectWritten(@Param("userId") String userId, @Param("page") Integer page);
}
