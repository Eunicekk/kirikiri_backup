package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

public interface UserService {
    public void signup(UserVO userVO);
    public UserVO login(UserVO userVO);
    public UserVO getUserVOById(String userId);
    // 회원정보 출력
    public UserVO getInfo(String userId);

    public Boolean duplicateCheckId(String userId);
    public Boolean duplicateCheckNickname(String userNickname);

    // 회원정보 수정
    public void updateInfo(UserVO userVO);

    // 회원정보 삭제
    public void deleteInfo(String userId);
}

