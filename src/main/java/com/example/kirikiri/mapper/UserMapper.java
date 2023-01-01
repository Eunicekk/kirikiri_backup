package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 유저 정보 조회
    public UserVO selectUser(String userId);

    // 유저 정보 업데이트
    public void updateUser(UserVO userVO);

    public void deleteUser(String userId);

}
