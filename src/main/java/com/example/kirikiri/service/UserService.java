package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

    public interface UserService {

    // Email로 데이터 가져오기
    public String findById(String userEmail);

    // ID로 데이터 가져오기
    public UserVO getUser(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);


}
