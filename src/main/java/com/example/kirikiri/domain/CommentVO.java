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
    private String contentRegisterDate;
    private String contentUpdateDate;
    private Integer contentLikes;
    private Long boardId;
    private String userId;
}
