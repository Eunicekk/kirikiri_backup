package com.example.kirikiri.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommentVO {
    private Long commentId;
    private String commentContent;
    private String commentRegisterDate;
    private String commentUpdateDate;
    private Integer commentLikes;
    private Long boardId;
    private String userId;
}
