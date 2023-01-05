package com.example.kirikiri.service;

import com.example.kirikiri.domain.ScrapDTO;
import com.example.kirikiri.domain.ScrapVO;
import com.example.kirikiri.repository.ScrapDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("scrap") @Primary
public class ScrapServiceImpl implements ScrapService{
    private final ScrapDAO scrapDAO;

    @Override
    public List<ScrapDTO> getScrappedBoard(String userId, Integer page) {
        return scrapDAO.scrappedBoard(userId, page);
    }

    @Override
    public void addScrap(ScrapVO scrapVO){
        scrapDAO.setScrap(scrapVO);
    }

    @Override
    public void deleteScrap(ScrapVO scrapVO) {
        scrapDAO.deleteScrap(scrapVO);
    }

    @Override
    public boolean checkScrap(ScrapVO scrapVO) {
        return (scrapDAO.getScrapVO(scrapVO) != null) ? true : false;
    }
}
