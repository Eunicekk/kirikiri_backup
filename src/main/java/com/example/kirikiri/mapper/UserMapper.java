package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void insert(UserVO userVO);

    public UserVO select(UserVO userVO);

    public UserVO selectById(String userId);

}
