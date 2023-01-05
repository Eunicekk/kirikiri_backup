package com.example.kirikiri.service;

import com.example.kirikiri.domain.ScrapDTO;
import com.example.kirikiri.domain.ScrapVO;

import java.util.List;

public interface ScrapService {

    // 스크랩한 게시글 조회
    public List<ScrapDTO> getScrappedBoard(String userId, Integer page);

    public void addScrap(ScrapVO scrapVO);

    public void deleteScrap(ScrapVO scrapVO);
}
