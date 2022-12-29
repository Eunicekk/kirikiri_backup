package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

public interface UserService {

    // 회원정보 출력
    public UserVO getInfo(String userId);
}