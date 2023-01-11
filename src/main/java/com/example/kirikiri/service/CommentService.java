package com.example.kirikiri.service;

import com.example.kirikiri.domain.CommentVO;

import java.util.List;

public interface CommentService {
    public CommentVO getCommentVO(Long commentId);
    public List<CommentVO> getCommentVOByUserId(String userId);
    public void addComment(CommentVO commentVO);
    public void deleteComment(Long commentId);
    public void updateComment(CommentVO commentVO);
}
