package com.example.kirikiri.service;

import com.example.kirikiri.domain.CommentVO;
import com.example.kirikiri.repository.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("comment") @Primary
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;


    @Override
    public CommentVO getCommentVO(Long commentId) {
        return commentDAO.getCommentVO(commentId);
    }

    @Override
    public void addComment(CommentVO commentVO) {
        commentDAO.addComment(commentVO);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentDAO.deleteComment(commentId);
    }

    @Override
    public void updateComment(CommentVO commentVO) {
        commentDAO.setComment(commentVO);
    }
}
