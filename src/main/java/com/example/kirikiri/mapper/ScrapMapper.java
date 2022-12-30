package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.ScrapDTO;
import com.example.kirikiri.domain.ScrapVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScrapMapper {

    // 스크랩한 게시글 출력
    public List<ScrapDTO> selectScrapped(@Param("userId") String userId, @Param("page") Integer page);

    public List<ScrapDTO> test(@Param("userId")String userId);
}
