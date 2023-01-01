package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

public interface UserService {
    public void signup(UserVO userVO);
    public UserVO login(UserVO userVO);
    public UserVO getUserVOById(String userId);
}
