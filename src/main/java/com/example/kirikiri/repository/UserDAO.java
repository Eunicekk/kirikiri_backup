package com.example.kirikiri.repository;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public void setUserVO(UserVO userVO) {
        userMapper.insert(userVO);
    }

    public UserVO getUserVO(UserVO userVO) {
        return userMapper.select(userVO);
    }

    public UserVO getUserVOById(String userId) {
        return userMapper.selectById(userId);
    }
}
