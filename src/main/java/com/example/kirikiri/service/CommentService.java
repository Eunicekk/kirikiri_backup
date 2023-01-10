package com.example.kirikiri.service;

import com.example.kirikiri.domain.CommentVO;

public interface CommentService {
    public CommentVO getCommentVO(Long commentId);
    public void addComment(CommentVO commentVO);
    public void deleteComment(Long commentId);
    public void updateComment(CommentVO commentVO);
}
