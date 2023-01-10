package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<CommentVO> selectByBoardId(Long boardId);

    public CommentVO selectByCommentId(Long commentId);

    public void insert(CommentVO commentVO);

    public void update(CommentVO commentVO);

    public void delete(Long commentId);

    public void deleteByBoardId(Long boardId);
}
