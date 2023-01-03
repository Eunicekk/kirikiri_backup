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

    //게시글수 카운트
    public Integer countAll();
    public Integer countCategory(BoardVO boardVO);
    public Integer countDetailCategory(BoardVO boardVO);
    public Integer countSearch(String keyword);
    public Integer countCategorySearch(BoardDTO boardDTO);
    public Integer countByUser(String userId);

    //게시글 목록
    public List<BoardVO> selectAll(Integer page);
    public List<BoardVO> selectAllByLikes(Integer page);
    public List<BoardVO> selectAllByViews(Integer page);

    //카테고리 목록

    public List<BoardVO> selectCategory(BoardDTO boardDTO);
    public List<BoardVO> selectCategoryByLikes(BoardDTO boardDTO);
    public List<BoardVO> selectCategoryByViews(BoardDTO boardDTO);
    
    //세부 카테고리 목록
    public List<BoardVO> selectDetailCategory(BoardDTO boardDTO);
    public List<BoardVO> selectDetailCategoryByLikes(BoardDTO boardDTO);
    public List<BoardVO> selectDetailCategoryByViews(BoardDTO boardDTO);

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


    public List<BoardVO> search(BoardDTO boardDTO);

    public List<BoardVO> searchByCategory(BoardDTO boardDTO);

    public List<BoardVO> selectFivePosts(String categoryName);

    public List<BoardVO> selectPopularPosts();
    public List<BoardDTO> selectPopularWriters();

    // 작성한 게시글 조회
    public List<BoardVO> selectWritten(@Param("userId") String userId, @Param("page") Integer page);
}
