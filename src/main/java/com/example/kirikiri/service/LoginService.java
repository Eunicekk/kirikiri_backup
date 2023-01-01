package com.example.kirikiri.service;

import com.vam.model.LoginVO;

public interface LoginService {
    /* 회원가입 */
    public void memberJoin(LoginVO member) throws Exception;
    /* 아이디 중복 검사 */
    public int idCheck(String memberId) throws Exception;
    /* 로그인 */
    public LoginVO memberLogin(LoginVO member) throws Exception;
}