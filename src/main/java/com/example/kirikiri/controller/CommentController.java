package com.example.kirikiri.controller;

import com.example.kirikiri.domain.CommentVO;
import com.example.kirikiri.repository.CommentDAO;
import com.example.kirikiri.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/*")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/add")
    public CommentVO addComment(CommentVO commentVO) {
        commentService.addComment(commentVO);

        CommentVO comment = commentService.getCommentVO(commentVO.getCommentId());

        return comment;
    }
    @GetMapping("/update")
    public CommentVO updateComment(CommentVO commentVO) {
        commentService.updateComment(commentVO);

        return commentVO;
    }
    @GetMapping("/remove")
    public void remove(Long commentId) {
        commentService.deleteComment(commentId);
    }
}
