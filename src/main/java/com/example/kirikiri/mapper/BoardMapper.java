package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface BoardMapper {




    // 작성한 게시글 조회
    public List<BoardVO> selectWritten(@Param("userId") String userId, @Param("page") Integer page);

}
