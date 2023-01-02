package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // Email로 데이터 조회
    public String selectUserEmail(String userEmail);

    // Id로 데이터 조회
    public UserVO selectUserId(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);

    // 임시 데이터 입력
    public void insert(UserVO userVO);




}