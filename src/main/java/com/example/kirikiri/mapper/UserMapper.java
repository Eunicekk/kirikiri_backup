package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void insert(UserVO userVO);

    public UserVO select(UserVO userVO);

    public UserVO selectById(String userId);

    // 유저 정보 조회
    public UserVO selectUser(String userId);

    // 유저 정보 업데이트
    public void updateUser(UserVO userVO);

    public void deleteUser(String userId);

    // Email로 데이터 조회
    public UserVO selectUserEmail(String userEmail);

    // Id로 데이터 조회
    public UserVO selectUserId(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);

}
