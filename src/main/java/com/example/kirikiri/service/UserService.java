package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

<<<<<<< HEAD
public interface UserService {
    public void signup(UserVO userVO);
    public UserVO login(UserVO userVO);
    public UserVO getUserVOById(String userId);
    // 회원정보 출력
    public UserVO getInfo(String userId);

    // 회원정보 수정
    public void updateInfo(UserVO userVO);

    // 회원정보 삭제
    public void deleteInfo(String userId);
=======
    public interface UserService {
>>>>>>> 319665cc80c20ee6a1e79404e302516cbcb43a4d

    // Email로 데이터 가져오기
    public String findById(String userEmail);

    // ID로 데이터 가져오기
    public UserVO getUser(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);
<<<<<<< HEAD
}

=======


}
>>>>>>> 319665cc80c20ee6a1e79404e302516cbcb43a4d
