package com.example.kirikiri.repository;

import com.example.kirikiri.domain.CommentVO;
import com.example.kirikiri.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDAO {
    private final CommentMapper commentMapper;

    public List<CommentVO> getCommentsListByBoardId(Long boardId) {
        return commentMapper.selectByBoardId(boardId);
    }

    public CommentVO getCommentVO(Long commentId) {
        return commentMapper.selectByCommentId(commentId);
    }

    public void addComment(CommentVO commentVO){
        commentMapper.insert(commentVO);
    }

    public void setComment(CommentVO commentVO) {
        commentMapper.update(commentVO);
    }

    public void deleteComment(Long commentId) {
        commentMapper.delete(commentId);
    }

    public void deleteByBoardId(Long boardId) {
        commentMapper.deleteByBoardId(boardId);
    }
}
