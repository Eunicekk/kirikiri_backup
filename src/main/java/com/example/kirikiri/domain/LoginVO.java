package com.example.kirikiri.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

public class LoginVO{
    //회원 id
    private String memberId;

    //회원 비밀번호
    private String memberPw;

    //회원 이름
    private String memberName;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    @Override
    public String toString() {
        return "LoginVO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName +"]";
    }



}