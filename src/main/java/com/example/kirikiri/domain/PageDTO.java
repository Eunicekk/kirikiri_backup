package com.example.kirikiri.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageDTO {
    private int startPage;
    private int endPage;
    private boolean prev, next;
    private int prevNo;
    private int nextNo;
    private int total;
    private int page = 1;

    public PageDTO createPageBoardDTO(int page, int total) {
        this.page = page;
        this.total = total;
        this.startPage = 1;
        this.endPage = (int)Math.ceil((double)total / 20);
        this.prev = startPage != page;
        this.next = endPage != page;
        if(prev) {
            this.prevNo = page - 1;
        }
        if(next){
            this.nextNo = page + 1;
        }

        return this;
    }
}
