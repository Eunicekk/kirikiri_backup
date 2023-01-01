package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;
import org.apache.catalina.User;

public interface UserService {

    // 회원정보 출력
    public UserVO getInfo(String userId);

    // 회원정보 수정
    public void updateInfo(UserVO userVO);

    // 회원정보 삭제
    public void deleteInfo(String userId);
}