package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
<<<<<<< HEAD
=======
    // Email로 데이터 조회
    public String selectUserEmail(String userEmail);

    // Id로 데이터 조회
    public UserVO selectUserId(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);

    // 임시 데이터 입력
>>>>>>> 319665cc80c20ee6a1e79404e302516cbcb43a4d
    public void insert(UserVO userVO);

    public UserVO select(UserVO userVO);

    public UserVO selectById(String userId);

    // 유저 정보 조회
    public UserVO selectUser(String userId);

    // 유저 정보 업데이트
    public void updateUser(UserVO userVO);

    public void deleteUser(String userId);

    // Email로 데이터 조회
    public String selectUserEmail(String userEmail);

    // Id로 데이터 조회
    public UserVO selectUserId(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);



}