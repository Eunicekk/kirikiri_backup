package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 유저 정보 조회
    public UserVO selectUser(String userId);

}
