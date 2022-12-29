package com.example.kirikiri.mapper;

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

    //카테고리 목록
    public List<BoardVO> selectCategory(String categoryName);
    
    //세부 카테고리 목록
    public List<BoardVO> selectDetailCategory(String detailCategoryName);

    //게시글 추가
    public void insert(BoardVO boardVO);

    //게시글 삭제
    public void delete(Long boardId);

    //게시글 수정
    public void update(BoardVO boardVO);

    //게시글 조회
    public BoardVO select(Long boardId);

    // 작성한 게시글 조회
    public List<BoardVO> selectWritten(@Param("userId") String userId, @Param("page") Integer page);
}
