package com.example.kirikiri.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ScrapDTO {
    private Long scrapId;
    private String userId;
    private Long boardId;
    private String scrapRegisterDate;
    private String categoryName;
    private String boardTitle;
}
